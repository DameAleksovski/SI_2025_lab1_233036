import java.util.*;

enum Priority {
    LOW, MEDIUM, HIGH
}

class Task {
    private String name;
    private boolean isCompleted;
    private Priority priority;
    private String category;

    public Task(String name, Priority priority, String category) {
        this.name = name;
        this.priority = priority;
        this.category = category;
        this.isCompleted = false;
    }

    public void complete() {
        this.isCompleted = true;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + " [" + category + "] - Priority: " + priority + (isCompleted ? " [Completed]" : " [Pending]");
    }
}

class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String name, Priority priority, String category) {
        tasks.add(new Task(name, priority, category));
    }

    public void printTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    // MISSING FEATURES:

    // 1. Remove a task by name
    // Remove a task by name
	public void removeTask(String name) {
    	tasks.removeIf(task -> task.getName().equals(name));
	}


    // 2. Find all completed tasks
    public List<Task> getCompletedTasks() {
    List<Task> completedTasks = new ArrayList<>();
    for (Task task : tasks) {
        if (task.isCompleted()) {
            completedTasks.add(task);
        }
    }
    return completedTasks;
}

    // 3. List tasks sorted by name
    public void sortTasksByName() {
        // TODO: Implement sorting logic
    }

    // 4. Sort tasks by priority
    public void sortTasksByPriority() {
    tasks.sort((task1, task2) -> {
        // Sort in descending order (HIGH first, then MEDIUM, then LOW)
        return task2.getPriority().compareTo(task1.getPriority());
    });
}

    // 5. Filter tasks by category
    public List<Task> filterByCategory(String category) {
        // TODO: Implement filtering logic
        return new ArrayList<>();
    }

    // 6. Find the highest-priority unfinished task
    public List<Task> getMostUrgentTasks() {
        // TODO: Implement logic to find most urgent tasks
        return new ArrayList<>();
    }

    // 7. Count tasks per category
    public Map<String, Integer> countTasksPerCategory() {
        // TODO: Implement counting logic
        return new HashMap<>();
    }

    // 8. Mark a task as completed by name
    public void markTaskCompleted(String name) {
        // TODO: Implement completion logic
    }

    // 9. Mark all tasks in a category as completed
    public void markCategoryCompleted(String category) {
        // TODO: Implement bulk completion logic
    }
}

public static void main(String[] args) {
    TaskManager manager = new TaskManager();
    manager.addTask("Write report", Priority.HIGH, "Work");
    manager.addTask("Buy groceries", Priority.LOW, "Personal");
    
    // Mark one task as completed
    manager.markTaskCompleted("Buy groceries");

    System.out.println("All tasks:");
    manager.printTasks();

    System.out.println("\nCompleted tasks:");
    List<Task> completed = manager.getCompletedTasks();
    for (Task task : completed) {
        System.out.println(task);
    }
}

