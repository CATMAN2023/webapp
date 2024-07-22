package ar.com.codo24101.domain;

public class Clubes {
    private Long id;
    private String name;
    private String logo;
    private Long fundado;
    private String provincia;
    private String estadio;
    private Long construido;
    private Long capacidad;
    private Long campprof;
    private Long campamat;
    private String categoria;
    
    public Clubes(Long id, String name, String logo, Long fundado, String provincia, String estadio, Long construido,
            Long capacidad, Long campprof, Long campamat, String categoria) {
        this.id = id;
        this.name = name;
        this.logo = logo;
        this.fundado = fundado;
        this.provincia = provincia;
        this.estadio = estadio;
        this.construido = construido;
        this.capacidad = capacidad;
        this.campprof = campprof;
        this.campamat = campamat;
        this.categoria = categoria;
    }

    public Clubes(String name, String logo, Long fundado, String provincia, String estadio, Long construido,
            Long capacidad, Long campprof, Long campamat, String categoria) {
        this.name = name;
        this.logo = logo;
        this.fundado = fundado;
        this.provincia = provincia;
        this.estadio = estadio;
        this.construido = construido;
        this.capacidad = capacidad;
        this.campprof = campprof;
        this.campamat = campamat;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Long getFundado() {
        return fundado;
    }

    public void setFundado(Long fundado) {
        this.fundado = fundado;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public Long getConstruido() {
        return construido;
    }

    public void setConstruido(Long construido) {
        this.construido = construido;
    }

    public Long getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Long capacidad) {
        this.capacidad = capacidad;
    }

    public Long getCampprof() {
        return campprof;
    }

    public void setCampprof(Long campprof) {
        this.campprof = campprof;
    }

    public Long getCampamat() {
        return campamat;
    }

    public void setCampamat(Long campamat) {
        this.campamat = campamat;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    
}
