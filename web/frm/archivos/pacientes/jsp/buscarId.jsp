
<%@page import="controladores.PacientesControlador"%>
<%@page import="modelos.Pacientes"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int id_paciente = Integer.parseInt(request.getParameter("id_paciente"));
    
    String tipo = "error";
    String mensaje = "Datos no encontrados.";
        String nuevo = "true";
        Pacientes paciente = new Pacientes();
        paciente.setId_paciente(id_paciente);

        PacientesControlador.buscarId(paciente);
        if (paciente.getId_paciente() != 0) {
            tipo = "success";
            mensaje = "Datos encontrados.";
            nuevo = "false";
        } else {
            paciente.setId_paciente(0);
            paciente.setCi_paciente(0);
            paciente.setNombre_paciente("");
            paciente.setApellido_paciente("");
         //   paciente.setFechanac_paciente("");
            paciente.setAltura_paciente("");
            paciente.setPeso_paciente(0);

            paciente.setDireccion_paciente("");
            paciente.setTelefono_paciente("");
            paciente.setCelular_paciente("");
            paciente.setEmail_paciente("");

            paciente.setProfesion_paciente("");
            paciente.setLugar_trabajo("");
            paciente.setSeguro_paciente("");

            /* Sexos sexo = new Sexos();
                    sexo.setId_sexo(0);
                    sexo.setNombre_sexo("");
             */
//                    paciente.setSexo(sexo);
        }
    
    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    obj.put("nuevo", nuevo);
    obj.put("id_paciente", paciente.getId_paciente());
    obj.put("ci_paciente", paciente.getCi_paciente());
    obj.put("nombre_paciente", paciente.getNombre_paciente());
    obj.put("apellido_paciente", paciente.getApellido_paciente());
    obj.put("fechanac_paciente", String.valueOf(paciente.getFechanac_paciente()));
    obj.put("altura_paciente", paciente.getAltura_paciente());
    obj.put("peso_paciente", paciente.getPeso_paciente());      
    obj.put("direccion_paciente", paciente.getDireccion_paciente());  
    obj.put("telefono_paciente", paciente.getTelefono_paciente()); 
    obj.put("celular_paciente", paciente.getCelular_paciente());  
    obj.put("email_paciente", paciente.getEmail_paciente()); 
    obj.put("profesion_paciente", paciente.getProfesion_paciente());     
    obj.put("lugar_trabajo", paciente.getLugar_trabajo());
    obj.put("seguro_paciente", paciente.getSeguro_paciente());  
    //obj.put("id_sexo", paciente.getSexo().getId_sexo());
    //obj.put("nombre_sexo", paciente.getSexo().getNombre_sexo());
    
    out.print(obj);
    out.flush();
%>
