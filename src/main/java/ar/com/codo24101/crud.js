let datos = [];

function listar() {
    //fetch('http://localhost/API/equipos.json') http://localhost/API/equipos.json
    //fetch('./API/equipos.json')
    //fetch(`http://localhost:3307/webapp/${endpoint}`)
    //fetch("http://localhost/API/equipos.json") //ES LA UNICA QUE FUNCIONO HASTA QUE SE BLOQUEO"

    fetch("./API/equipos.json")
    fetch('http://localhost/API/equipos.json')
    .then(response => response.json())
    .then(data => {
        Filas(data)
        datos = data;
    /*.then(response => response.json())
    .then(data => {
        allTeamsData = data; // Almacena todos los datos de equipos
        renderTeamList(data); // Renderiza la lista de equipos inicial
        updateUI(datos);
        // Agrega event listeners
        addEventListeners();*/
    }
    
)
    //.catch(error => console.error('Error:', error));

    // .then(response => response.json())
     //.then(data => {
        //datos = data;
        //updateUI(datos);
     // });
  }

  function Filas(filas) {
    const rows = filas.map(x => Fila(x));     

    document.getElementById('datos').innerHTML = rows.join('');
}

function eliminar(id) {
    const eliminar = confirm('¿Eliminar?');//true|false
    if(eliminar) {
        fetch(`http://localhost:3307/webapp/EliminarClubesController?id=${id}`,{
            method:'delete',
        }).then(response => listar());
    }
}

function editar(id){
 const objetoaeditar = datos.find(x=> x.id === id);
 document.getElementById('id').value = objetoaeditar.id;
 document.getElementById('name').value = objetoaeditar.name;
 document.getElementById('logo').value = objetoaeditar.logo;
 document.getElementById('fundado').value = objetoaeditar.fundado;
 document.getElementById('provincia').value = objetoaeditar.provincia;
 document.getElementById('estadio').value = objetoaeditar.estadio;
 document.getElementById('construido').value = objetoaeditar.construido;
 document.getElementById('capacidad').value = objetoaeditar.capacidad;
 document.getElementById('campprof').value = objetoaeditar.campprof;
 document.getElementById('campamat').value = objetoaeditar.campamat;
 document.getElementById('categoria').value = objetoaeditar.categoria;

}

function Fila(obj) {
    return `
        <tr>
            <td>${obj.id}</td>
            <td>${obj.name}</td>
            <td>${obj.logo}</td>
            <td>${obj.fundado}</td>
            <td>${obj.provincia}</td>
            <td>${obj.estadio}</td>
            <td>${obj.construido}</td>
            <td>${obj.capacidad}</td>
            <td>${obj.campprof}</td>
            <td>${obj.campamat}</td>
            <td>${obj.categoria}</td>
            
            <td>
                <a href="#" onclick="eliminar(${obj.id})">X</a>
                <a href="#" onclick="editar(${obj.id})">E</a>
            </td>
        </tr>
    `
}

//al cargar la pagina
listar();

function limpiar(){
//guardo el id del registro que quiero editar
 document.getElementById('id').value = '';
 document.getElementById('name').value = '';
 document.getElementById('logo').value = '';
 document.getElementById('fundado').value = '';
 document.getElementById('provincia').value = '';
 document.getElementById('estadio').value = '';
 document.getElementById('construido').value = '';
 document.getElementById('capacidad').value = '';
 document.getElementById('campprof').value = '';
 document.getElementById('campamat').value = '';
 document.getElementById('categoria').value = '';
}

    function guardar(){
        const id =document.getElementById('id').value
        const name =document.getElementById('name').value
        const logo =document.getElementById('logo').value
        const fundado =document.getElementById('fundado').value
        const provincia =document.getElementById('provincia').value
        const estadio =document.getElementById('estadio').value
        const construido =document.getElementById('construido').value
        const capacidad =document.getElementById('capacidad').value
        const campprof =document.getElementById('campprof').value
        const campamat =document.getElementById('campamat').value
        const categoria =document.getElementById('categoria').value
    
        console.log(id,name,logo,fundado,provincia,estadio,construido,capacidad,campprof,campamat,categoria);
        if (!id || !name || !logo || !fundado || !provincia || !estadio || !construido || !capacidad || !campprof || !campamat || !categoria) {
            console.error('Faltan campos por llenar');
            return;
          }
        const jsonRequest = JSON.stringify({
        //const jsonRequest = {   
                id: id,
                name: name,
                logo: logo,
                fundado: fundado,
                provincia: provincia,
                estadio: estadio,
                construido: construido,
                capacidad: capacidad,
                campprof: campprof,
                campamat: campamat,
                categoria: categoria
             
        });
        //const json = JSON.stringify(jsonRequest);
        const jsonText = JSON.stringify(jsonRequest);
        const endpoint = id? 'ModificarClubesController' : 'CrearClubesControles';
        
        //fetch(`http://localhost:3307/webapp/${endpoint}`,{
        fetch('http://localhost/API/equipos.json',{
            method:'post',
            body: jsonText,
            headers:{
                'Content-Type':'text/json'
            }
        })
        .then(response => console.log(response))
        .then(data => {
            limpiar();
            listar()
        }
        );
    }
    
        
        
        
        /*const url = `http://localhost:3307/webapp/${endpoint}`;

        try {
            const respuesta =  fetch('http://localhost:3307/webapp/CrearClubesController', {
              method: 'POST',
             body: JSON.stringify(jsonRequest),
              headers: new Headers({
                'Content-Type': 'application/json'
              })
            });
            const datos =  respuesta.json; // <--- Agregué los paréntesis
            if (datos.success) {
                console.log('Datos guardados correctamente');
              limpiar();
              listar();
            } else {
              console.error('Error al guardar datos:', datos.error);
            }
          } catch (error) {
            console.error('Error al enviar solicitud:', error);
          }
        }*/
        
 
    //FETCH POST al server await fetch('http://localhost:3306/webapp/ModificarClubesController?id=$(id)',{
    /*fetch('http://localhost:3307/webapp/${endpoint}',{
        method: 'POST',
        body: json.stringify(jsonRequest),
        headers: new Headers({
            'Content-Type':'text/json'
        })
    }
);
limpiar();
listar();*/
//function listar(){
   // const json= fetch('http://localhost:3306/webapp/ListarClubesController')
    //.then(response=>response.json())
//}





