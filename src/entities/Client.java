package entities;

import structures.Heap;
public class Client {
	
	private String fullName;
	private String address;
	private String CPF;
	private Heap<Service> services;
	
	public Client(String fullName, String address, String CPF, Service service) {
		super();
		this.fullName = fullName;
		this.address = address;
		this.CPF = CPF;
		
		services = new Heap<Service>(300);
		addService(service);
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void addService(Service service) {
		this.services.insert(service.getId(), service);
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}
	
	public Service getService(Integer id) {
		return this.services.keyOf(id);
	}
	
	public Heap<Service> getServices() {
		return this.services;
	}

	@Override
	public String toString() {
		return "Client [fullName=" + fullName + ", address=" + address + ", CPF=" + CPF + "]";
	}

	
	@Override
	public boolean equals(Object obj){
		Client c = (Client) obj;
		return this.CPF.compareTo(c.getCPF()) <= 0;
	}
	
}
