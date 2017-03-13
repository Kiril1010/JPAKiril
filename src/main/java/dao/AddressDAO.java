package dao;

public interface AddressDAO<T> {
    T getAddressById();
    void saveAddress(T address);
}

