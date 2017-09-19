package serilization;

/**
 * Created by zjm on 2017/3/3.
 */
public class BaseObject {

    private String userName;
    private String userCode;
    private double weight;
    private int height;
    private boolean sex;
    private String[] array;
    private BaseObject innerBaseObject;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public BaseObject getInnerBaseObject() {
        return innerBaseObject;
    }

    public void setInnerBaseObject(BaseObject innerBaseObject) {
        this.innerBaseObject = innerBaseObject;
    }
}
