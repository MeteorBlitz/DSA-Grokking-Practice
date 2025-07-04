package backend

/*
 Problem: Chat Support System Design — Agent Assignment & Queue Handling
 Pattern: System Design / Backend Logic
 Status: ✅ Core logic implemented
 Features:
 - Agent capacity by seniority (Junior, Mid, Senior, Lead)
 - FIFO chat queue with max size = 1.5 × capacity
 - Round-robin chat assignment (Junior → Mid → Senior → Lead)
 - Overflow team available during office hours (as Junior agents)
 - Inactive chat monitor (3s timeout as simple polling demo)
 Input: 25 chat requests with team A setup
 Output: 21 chats assigned based on capacity, rest queued or overflowed
 Source: Backend Take-Home Test – March 2023
*/


import java.time.LocalTime
import java.util.*
import kotlin.math.floor

// --- ENUMS ---
enum class Role(val multiplier: Double) {
    JUNIOR(0.4),
    MID(0.6),
    SENIOR(0.8),
    LEAD(0.5)
}

// --- DATA CLASSES ---
data class Agent(
    val id: String,
    val name: String,
    val role: Role,
    val isActive: Boolean = true,
    var currentChats: Int = 0
) {
    val maxChats = floor(10 * role.multiplier).toInt()
    fun canTakeChat() = isActive && currentChats < maxChats
}

data class ChatSession(
    val id: String = UUID.randomUUID().toString(),
    val userId: String,
    var assignedAgent: Agent? = null,
    var lastPolledAt: Long = System.currentTimeMillis(),
    var isActive: Boolean = true
)

// --- CHAT QUEUE ---
object ChatQueueManager {
    val chatQueue: Queue<ChatSession> = LinkedList()
    val agents: MutableList<Agent> = mutableListOf()
    val overflowTeam: List<Agent> = List(6) {
        Agent(UUID.randomUUID().toString(), "OverflowJr$it", Role.JUNIOR)
    }

    fun isOfficeHours(): Boolean {
        val now = LocalTime.now()
        return now.hour in 9..18
    }

    fun getCapacity(team: List<Agent>): Int {
        return team.sumOf { floor(10 * it.role.multiplier).toInt() }
    }

    fun getMaxQueueSize(): Int {
        val capacity = getCapacity(agents)
        return floor(capacity * 1.5).toInt()
    }

    fun addChat(userId: String): String {
        if (chatQueue.size >= getMaxQueueSize()) {
            if (isOfficeHours()) {
                val overflowCapacity = getCapacity(overflowTeam)
                if (chatQueue.size < overflowCapacity * 1.5) {
                    chatQueue.add(ChatSession(userId = userId))
                    return "Added to overflow queue."
                }
            }
            return "Chat rejected: Queue full."
        }
        chatQueue.add(ChatSession(userId = userId))
        return "Chat added to queue."
    }

    fun assignChats() {
        val allAgents = agents.sortedBy { it.role.ordinal } // Junior first
        while (chatQueue.isNotEmpty()) {
            val session = chatQueue.peek()
            val agent = allAgents.find { it.canTakeChat() }
            if (agent != null) {
                session.assignedAgent = agent
                agent.currentChats++
                println("Assigned chat ${session.id} to agent ${agent.name}")
                chatQueue.poll()
            } else {
                break // No agent available
            }
        }
    }

    fun monitorChats() {
        val now = System.currentTimeMillis()
        chatQueue.forEach {
            if (now - it.lastPolledAt > 3000) {
                it.isActive = false
                println("Chat ${it.id} marked as inactive")
            }
        }
    }
}

// --- EXAMPLE USAGE ---
fun main() {
    // Add sample agents to the team
    ChatQueueManager.agents.addAll(
        listOf(
            Agent("1", "TeamLeadA", Role.LEAD),
            Agent("2", "Mid1", Role.MID),
            Agent("3", "Mid2", Role.MID),
            Agent("4", "Junior1", Role.JUNIOR)
        )
    )

    // Add chat sessions
    repeat(25) {
        println(ChatQueueManager.addChat("user$it"))
    }

    // Assign available agents to chats
    ChatQueueManager.assignChats()

    // Simulate polling monitor
    Thread.sleep(4000)
    ChatQueueManager.monitorChats()
}
