package dao;

import relationship.unidirectional.AddressUni;

public class NoSQLAddressDAO implements AddressDAO<AddressUni>{

    @Override
    public AddressUni getAddressById() {
        return null;
    }

    @Override
    public void saveAddress(AddressUni address) {
    }
}
