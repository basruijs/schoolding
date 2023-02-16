function makeSchool() {
    const req = new XMLHttpRequest();
    req.onload = function() {
        document.getElementById("test-school").innerHTML = this.responseText;
    }
   req.open("GET", "http://localhost:8082/api/school/all");
   req.send();
}

function buildSchoolTable(data) {
    const tableBody = document.getElementById("table");
    tableBody.innerHTML = "";
    for (let i = 0; i < data.length; i++) {
        let row = `<tr>
                        <td>${data[i].name}</td>
                        <td>${data[i].amountOfStudents}</td>
                   </tr>`;
    tableBody.innerHTML += row;
    }
}

async function getAllSchools() {
    const result = await fetch("http://localhost:8082/api/school/all");
    const data = await result.json();
    buildSchoolTable(data);
}

async function searchSchoolByName() {
    const name = document.getElementById("name").value;
    const result = await fetch(`http://localhost:8082/api/school/name/${name}`);
    const data = await result.json();
    makeSchoolResult(data);
}

function makeSchoolResult(data) {
    const element = document.getElementById("zoekresultaat");

    if (data.length === 0) {
        element.innerHTML = "Geen resultaten";
        return;
    }


        element.innerHTML = "";
    for (let i = 0; i < data.length; i++) {
        let row = `<tr>
                        <td>${data[i].name}</td>
                        <td>${data[i].amountOfStudents}</td>
                   </tr>`;
    element.innerHTML += row;
    }
}

function buildStudentTable(data) {
    const studentTable = document.getElementById("studenttable");
    studentTable.innerHTML = "";
    for (let i = 0; i < data.length; i++) {
        let row = `<tr>
                        <td>${data[i].name}</td>
                        <td>${data[i].schoolClass}</td>
                        <td>${data[i].schoolId}</td>

                   </tr>`;
    studentTable.innerHTML += row;
    }
}

async function getAllStudents() {
    const result = await fetch("http://localhost:8082/api/student/all");
    const data = await result.json();
    buildStudentTable(data);
}

