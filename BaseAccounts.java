public abstract class BaseAccounts {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) throws BusinessException {
        this.name = name;
    }
}
