async function newContactPerson() {
    const data = {name: document.getElementById("name").value, phoneNr: document.getElementById("phoneNr").value};
    dataJSON = JSON.stringify(data);

    const result = await fetch("http://localhost:8082/api/student/"+ document.getElementById("student").value +"/newContactPerson", {
        method: "PUT",
        headers: {
            'Content-Type': 'application/json'
        },
        body: dataJSON
    });
    const resultData = await result.json();
    console.log(data);
}