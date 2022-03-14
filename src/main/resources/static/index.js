function fetchFunction() {
  const comboColumns = document.querySelector("#columns");
  const comboOptions = document.querySelector("#options");

  fetchColumn(comboColumns.value, comboOptions.value);
}

function fetchColumn(column, option) {
  $.ajax({
    type: "POST",
    url: "http://localhost:8080/examples/" + column + "/" + option,
    dataType: "json",
    success: function (json) {
      //let columns = document.querySelector("#divColumns");
      let table = createHeaderTable();

      $("#divColumns").html(createTBodyTable(json, table));
    },
  });
}

function createHeaderTable() {
  let table = document.createElement("table");

  let th = document.createElement("th");

  let trId = document.createElement("tr");
  trId.innerText = "id";
  th.appendChild(trId);

  let trKolumna1 = document.createElement("tr");
  trKolumna1.innerText = "kolumna1";
  th.appendChild(trKolumna1);

  let trKolumna2 = document.createElement("tr");
  trKolumna2.innerText = "kolumna2";
  th.appendChild(trKolumna2);

  let trKolumna3 = document.createElement("tr");
  trKolumna3.innerText = "kolumna3";
  th.appendChild(trKolumna3);

  let trKolumna4 = document.createElement("tr");
  trKolumna4.innerText = "kolumna4";
  th.appendChild(trKolumna4);

  table.appendChild(th);

  return table;
}

function createTBodyTable(data, table) {
  data.forEach(element => {
    let row = document.createElement("td");

    let cell1 = document.createElement("tr");
    cell1.innerText = element.id;
    row.appendChild(cell1);

    let cell2 = document.createElement("tr");
    cell2.innerText = element.kolumna1;
    row.appendChild(cell2);

    let cell3 = document.createElement("tr");
    cell3.innerText = element.kolumna2;
    row.appendChild(cell3);

    let cell4 = document.createElement("tr");
    cell4.innerText = element.kolumna3;
    row.appendChild(cell4);

    let cell5 = document.createElement("tr");
    cell5.innerText = element.kolumna4;
    row.appendChild(cell5);

    table.appendChild(row);
  });
  return table;
}


fetchFunction();
