package models;

public class Parking {
	 private Integer id;
     private String location;
     private Integer Bike;
     private Integer EBike;
     private Integer TBike;
     private Integer Biked;
     private Integer EBiked;
     private Integer TBiked;
     public Integer getId(){
    	 return id;
     }
     public void setId(Integer id) {
    	 this.id=id;
     }
     public String getLocation() {
    	 return location;
     }
     public void setLocation(String location) {
    	 this.location=location;
     }
     public Integer getBike() {
    	 return Bike;
     }
     public void setBike(Integer Bike) {
    	 this.Bike=Bike;
     }
     public Integer getTBike() {
    	 return TBike;
     }
     public void setTBike(Integer TBike) {
    	 this.TBike=TBike;
     }
     public Integer getBiked() {
    	 return Biked;
     }
     public void setBiked(Integer Biked) {
    	 this.Biked=Biked;
     }
     public Integer getEBiked() {
    	 return EBiked;
     }
     public void setEBiked(Integer EBiked) {
    	 this.EBiked=EBiked;
     }
     public Integer getTBiked() {
    	 return TBiked;
     }
     public void setTBiked(Integer TBiked) {
    	 this.TBiked=TBiked;
     }
     public Integer getEBike() {
    	 return EBike;
     }
     public void setEBike(Integer EBike) {
    	 this.EBike=EBike;
     }
}
