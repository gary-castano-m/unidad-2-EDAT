package veterinaria;

import java.util.Objects;

public class MascotaAtencion {

    private String codigoAtencion;
    private String nombreMascota;
    private String especie;
    private String nombrePropietario;
    private String motivoConsulta;
    private String estado;

    public MascotaAtencion(String codigoAtencion,
                           String nombreMascota,
                           String especie,
                           String nombrePropietario,
                           String motivoConsulta,
                           String estado) {

        this.codigoAtencion = codigoAtencion;
        this.nombreMascota = nombreMascota;
        this.especie = especie;
        this.nombrePropietario = nombrePropietario;
        this.motivoConsulta = motivoConsulta;
        this.estado = estado;
    }

    public String getCodigoAtencion() {
        return codigoAtencion;
    }

    public void setCodigoAtencion(String codigoAtencion) {
        this.codigoAtencion = codigoAtencion;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigoAtencion +
                " | Mascota: " + nombreMascota +
                " | Especie: " + especie +
                " | Propietario: " + nombrePropietario +
                " | Motivo: " + motivoConsulta +
                " | Estado: " + estado;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        MascotaAtencion that = (MascotaAtencion) obj;

        return Objects.equals(codigoAtencion, that.codigoAtencion);
    }
}