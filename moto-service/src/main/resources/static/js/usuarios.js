// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios();
  $('#usuarios').DataTable();
});

 async function cargarUsuarios(){
const request = await fetch("/usuarios",
{
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    method: "GET"
});

const usuarios = await request.json();

console.log(usuarios);
let listadohtml = '';
for (let usuario of usuarios){
  let usuariohtml = '<tr><td>'+usuario.id+'</td><td>'+ usuario.nombre + ' ' +usuario.apellido +'</td><td>'+ usuario.email+'</td><td>'+usuario.telefono+'</td><td><a href="#" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a></td></tr>';
  listadohtml += usuariohtml;
}




document.querySelector('#usuarios tbody').outerHTML = listadohtml;


}