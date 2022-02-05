package web.carranza.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
@Data
public class clienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre", length = 100)
    private String nombre;

    @Column(name = "email",length = 255,unique = true)
    private String email;

    @Column(name = "telefono",length = 80)
    private String telefono;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    

}
