package entities;

public class Service {
	private Integer id;
	private String description;
	private Integer quantity;
	private String status;
	
	public Service(Integer id, String description, Integer quantity, String status) {
		super();
		this.id = id;
		this.description = description;
		this.quantity = quantity;
		this.status = status;
	}
	
	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Service [description=" + description + ", quantity=" + quantity + ", status=" + status + "]";
	}	
	
}
