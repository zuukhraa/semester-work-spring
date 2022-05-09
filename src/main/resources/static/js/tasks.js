async function getAllTasks() {
    const res = await fetch('http://localhost:8081/tasks/getAllTasks');
    const tasks = await res.json();

    console.log(tasks);
    tasks.forEach(task => taskToHTML(task))
}

window.addEventListener('DOMContentLoaded', getAllTasks);

function taskToHTML({id, completed, title}) {
const taskList = document.getElementById('tasks');
taskList.insertAdjacentHTML('beforeend',
    `    <div class="form-check" id="task${id}">
<label class="form-check-label">
    <input type="checkbox" class="form-check-input" ${completed && 'checked'}>
    ${title}
    </label>
        <button type="button" class="btn-close"
                aria-label="Close" style="font-size: 10px"></button>
    </div>`
);
}
