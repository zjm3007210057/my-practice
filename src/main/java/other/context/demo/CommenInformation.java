package other.context.demo;

/**
 * Created by zjm on 2017/2/21.
 */
public class CommenInformation {

    private String name;

    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "CommenInformation{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
