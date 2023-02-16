async function newStudent() {
    const data = {name: document.getElementById("name").value, schoolClass: document.getElementById("class").value, school: document.getElementById("school").value};
    dataJSON = JSON.stringify(data);

    const result = await fetch("http://localhost:8082/api/school/"+ data.school +"/newStudent", {
        method: "PUT",
        headers: {
            'Content-Type': 'application/json'
        },
        body: dataJSON
    });
    const resultData = await result.json();
    console.log(data);
}