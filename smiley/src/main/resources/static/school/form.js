async function newSchool() {
    const data = {name: document.getElementById("name").value};
    dataJSON = JSON.stringify(data);

    const result = await fetch("http://localhost:8082/api/school/new", {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: dataJSON
    });
    const resultData = await result.json();
    console.log(data);
}