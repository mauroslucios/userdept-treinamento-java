# userdept-treinamento-java
Nesta API Rest vamos criar os seguintes casos de uso:
- Buscar todos usuários;
- Buscar uma entidade por id;
- Inserir um novo usuário.

Teremos os endpoints:
- /api/users → get de todos usuários
- /api/users/{id} → get de um único usuário
- /api/users/ → insert de usuário
    

Ferramentas:
- spring tools suite ou IDE de sua preferência.
- postman

Tecnoloagias:
- spring;
- jpa;
- swagger;
- mysql dockerizado;
- postgresql;
- devtools
- web;
- lombok

## Url swagger
-http://localhost:8080/swagger-ui.html


## querys
- insert into tb_user values(null,'funcionario1@email.com','funcionario 1',4);
- select u.id as codigo, u.email as 'email funcionario', u.name as 'nome funcionario', d.name as 'departamento trabalha', d.id as 'codigo
 departamento' from tb_user as u  inner join tb_department as d on u.department_id = d.id;
## Imagens

![usuraios_departamentos](https://user-images.githubusercontent.com/671694/147854640-e8e25bdf-4a0e-4f47-9119-352266980fa7.jpg)

![Captura de tela de 2023-02-12 13-54-12](https://user-images.githubusercontent.com/671694/218325069-2a62d1dd-2071-40b4-b629-5510e87af7ef.png)


![java](https://user-images.githubusercontent.com/671694/147854651-cb185a41-2441-4cd9-af92-c3faf4b00299.jpg)

![java](https://user-images.githubusercontent.com/671694/147860506-b6aa4341-3ffe-4c37-a2ad-07414293b1c2.png)
