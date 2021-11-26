package entities;

import structures.RedBlackTree;

public class Client {
	
	private String fullName;
	private String address;
	private String CPF;
	private RedBlackTree<Integer, Service> services;
	
	public Client(String fullName, String address, String CPF, Service service) {
		super();
		this.fullName = fullName;
		this.address = address;
		this.CPF = CPF;
		
		services = new RedBlackTree<Integer, Service>();
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
		this.services.put(service.getId(), service);
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}
	
	public Service getService(Integer id) {
		return this.services.get(id);
	}

	@Override
	public String toString() {
		return "Client [fullName=" + fullName + ", address=" + address + ", CPF=" + CPF + "]";
	}

	
	
	
}
