package com.example.appesieav2.Model;

/*Objet STAFF - structure resprésentant un item de l'organigramme*/
public class Staff {
    private String nom;
    private String poste;
    private String image;
    private String mail;
    private String loc;

    public String getLoc() { return loc; }

    public void setLoc(String loc) { this.loc = loc; }

    public String getMail() { return mail; }

    public void setMail(String mail) { this.mail = mail; }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "nom='" + nom + '\'' +
                ", poste='" + poste + '\'' +
                ", image='" + image + '\'' +
                ", mail='" + mail + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}
