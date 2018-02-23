package project_Nestle;

public class Table_data {

	String num;
	String site;
	String city;
	String zone;
	String function;
	
	Table_data(){
		
		num="";
		site="";
		city="";
		zone="";
		function="";
	}
	Table_data(String num,String site,String city,String zone,String function){
		this.num =num;
		this.site =site;
		this.city =city;
		this.zone =zone;
		this.function = function;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	
}
