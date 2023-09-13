package pojos;

public class DummyResponsePojo {
    private String status;
    private DummyDataPojo data;
    private String message;

    public DummyResponsePojo() {
    }

    public DummyResponsePojo(String status, DummyDataPojo data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DummyDataPojo getData() {
        return data;
    }

    public void setData(DummyDataPojo data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DummyResponsePojo{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
