

<div align="center">
  <a href="[https://github.com/othneildrew/Best-README-Template](https://github.com/sebastian-contreras/)">
    <img src="https://w7.pngwing.com/pngs/589/438/png-transparent-cat-paw-kitten-dog-cat-animals-pet-paw.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">Backend Pets System</h3>

  <p align="center">
   Backend de Sistema de gestion de veterinaria
  
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Tabla de contenidos</summary>
  <ol>
    <li>
      <a href="#sobre-el-proyecto">Sobre el proyecto</a>
      <ul>
        <li><a href="#construccion">Contruido con: </a></li>
        <li><a href="#base-de-datos">Base de datos </a></li>
      </ul>
    </li>
    <li><a href="#endpoints">Endpoints</a></li>
    <li><a href="#contacto">Roadmap</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## Sobre el proyecto<a name="Sobre-el-proyecto"></a>

El backend de mi proyecto, denominado "Pet System", ha sido desarrollado utilizando Java Spring Boot y utiliza JPA Hibernate con una base de datos MySQL. Este sistema ofrece autenticación de usuarios a través de JWT con Roles y abarca todos los aspectos de una clínica veterinaria, incluyendo la gestión de clientes, veterinarios, mascotas, citas, historias clínicas y próximamente también el seguimiento de insumos, compras y ventas realizadas por los empleados. Además, proporciona estadísticas relacionadas con ingresos, mascotas y un ranking de veterinarios.
<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Construccion<a name="Construccion"></a>

This section should list any major frameworks/libraries used to bootstrap your project. Leave any add-ons/plugins for the acknowledgements section. Here are a few examples.

- Maven
- Spring Web
- Spring Devtols
- MYSQL Drivers
- Lombok
- Spring Data JPA
- JWT
      
### Base de datos<a name="Base-de-datos"></a>

Esta API utiliza Base de datos relacionales cuyo gestor de base de datos elegido es MYSQL, El diagrama fisico de la base de datos es el siguiente:

![Diagrama fisico de Base de datos](/DisenoBD/modeloArreglado.png)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Endpoints<a name="Endpoints"></a>

### Métodos GET

| Endpoint                           | Descripción                                           |
| ---------------------------------- | ----------------------------------------------------- |
| `/api/clientes`                     | Obtiene la lista de clientes.                        |
| `/api/empleados`                    | Obtiene la lista de empleados.                       |
| `/api/veterinarios`                  | Obtiene la lista de veterinarios.                    |
| `/api/clientes/{dni}`               | Obtiene un cliente por su número de identificación. |
| `/api/empleados/{dni}`              | Obtiene un empleado por su número de identificación.|
| `/api/veterinarios/{dni}`            | Obtiene un veterinario por su número de identificación. |
| `/api/mascotas`                      | Obtiene la lista de mascotas.                        |
| `/api/mascotas/{dni}`               | Obtiene las mascotas de un cliente por su número de identificación. |
| `/api/mascotas/perfil/{id}`          | Obtiene el perfil de una mascota por su ID.          |
| `/api/citas`                        | Obtiene la lista de citas.                           |
| `/api/citas/{dni}`                 | Obtiene las citas de un cliente por su número de identificación. |
| `/api/citasveterinario/{dni}`       | Obtiene las citas de un veterinario por su número de identificación. |
| `/api/citaspendiente`               | Obtiene la lista de citas pendientes.                |
| `/api/citaspendiente/{dni}`        | Obtiene las citas pendientes de un cliente por su número de identificación. |
| `/api/citasmascota/{id}`            | Obtiene las citas de una mascota por su ID.          |
| `/api/historia/{id}`                | Obtiene la historia clínica de una mascota por su ID. |
| `/api/estadistica/mascota`                     | Obtiene estadísticas relacionadas con las mascotas.  |
| `/api/estadistica/ganancia`                    | Obtiene estadísticas relacionadas con las ganancias. |
| `/api/estadistica/gananciavet`                 | Obtiene estadísticas de ganancias de un veterinario. |
| `/api/estadistica/gananciavet/{dni}`           | Obtiene estadísticas de ganancias de un veterinario por su número de identificación. |
| `/api/estadistica/topvet`                      | Obtiene el ranking de veterinarios en función de sus ganancias. |

### Método POST

| Endpoint                           | Descripción                                           |
| ---------------------------------- | ----------------------------------------------------- |
| `/api/persona/save`                  | Crea una nueva persona (cliente, empleado o veterinario). |
| `/api/mascotas/save`                 | Crea una nueva mascota.                              |
| `/api/citas/save`                    | Crea una nueva cita.                                 |
| `/auth/register`                     | Registro de usuarios.                                |
| `/auth/login`                        | Autenticación de usuarios.                           |
### Método DELETE

| Endpoint                           | Descripción                                           |
| ---------------------------------- | ----------------------------------------------------- |
| `/api/persona/ID`                    | Elimina una persona por su ID.                       |
| `/api/mascotas/ID`                   | Elimina una mascota por su ID.                       |
| `/api/citaspendiente/id`             | Elimina una cita pendiente por su ID.                |

### Método PUT

| Endpoint                           | Descripción                                           |
| ---------------------------------- | ----------------------------------------------------- |
| `/api/historia/createhistoria/id`    | Convierte una cita en una historia clínica.          |



<!-- CONTACT -->
## Contacto

Sebastian Contreras - [Linkedin]([https://twitter.com/your_username](https://www.linkedin.com/in/sebastian-contreras-unt/)) - sebasfac2017@gmail.com


<p align="right">(<a href="#readme-top">back to top</a>)</p>
