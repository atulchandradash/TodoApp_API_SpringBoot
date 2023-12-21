
const apiUrl = 'http://localhost:8080/api/todos';

fetch(apiUrl)
    .then(response => {
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        return response.json();
    })
    .then(data => {
        displayData(data.data);
    })
    .catch(error => {
        console.error('Fetch error:', error);
    });

function displayData(data) {
    const dataContainer = document.getElementById('dataContainer');


    dataContainer.innerHTML = '';


    console.log('API Data:', data);


    if (Array.isArray(data)) {

        data.forEach(item => {
            createListItem(item);
        });
    } else if (typeof data === 'object') {

        createListItem(data);
    } else {
        console.error('API Data is not an array or object.');
    }

    function createListItem(item) {
        const listItem = document.createElement('li');
        listItem.innerHTML = `
            <div class="d-flex justify-content-between">
              <div style="${item.complete ? 'text-decoration: line-through;' : ''}">${item.todo}</div>
              <div class="button_container">
                <button ${item.complete ? 'disabled' : ''} type="button" class="btn btn-success" onclick="completeTodo(${item.id})">
                  <i class="bi bi-check-circle-fill"></i>
                </button>
                <button ${item.complete ? '' : 'disabled'} type="button" class="btn btn-danger" onclick="deletedTodo(${item.id})">
                  <i class="bi bi-trash"></i>
                </button>
              </div>
            </div>
          `;
        dataContainer.appendChild(listItem);
    }
}



function completeTodo(todoId) {

    console.log(`Completing todo with ID ${todoId}`);

    const apiUrl = `http://localhost:8080/api/todos/${todoId}`;

    fetch(apiUrl, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        console.log(`Todo with ID ${todoId} deleted successfully.`);
        window.location.reload();
    })
    .catch(error => {
        console.error('Delete error:', error);
    });
}


function deletedTodo(todoId) {

    console.log(`Completing todo with ID ${todoId}`);


    const apiUrl = `http://localhost:8080/api/todos/${todoId}`;

    fetch(apiUrl, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
            },
        })
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            console.log(`Todo with ID ${todoId} deleted successfully.`);
            window.location.reload();
        })
        .catch(error => {
            console.error('Delete error:', error);
        });
}



function addTodos() {

    const todoInput = document.getElementById('todo');
    const todo = todoInput.value;
  

    if (!todo) {
      alert('Please enter a todo before adding.');
      return;
    }


    const requestData = {
        todo: todo,
    };


    console.log('Request Data:', requestData);
  

    const apiUrl = 'http://localhost:8080/api/todos';
  
    fetch(apiUrl, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        todo: todo,
      }),
      
    })
      .then(response => {
        if (!response.ok) {
          throw new Error(`HTTP error! Status: ${response.status}`);
        }
        console.log('Todo added successfully.');
  

        window.location.reload();
      })
      .catch(error => {
        console.error('Add todo error:', error);
      });
  }
  


