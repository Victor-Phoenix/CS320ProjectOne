/**
 * Author: Victor Tran
 * Date: 07/23/2024
 * Description: This class provides services to add, update, and delete contacts in an in-memory data structure.
 */
package ProjectOne;
import java.util.ArrayList;
import java.util.List;

public class ContactService {
    private List<Contact> contacts;

    public ContactService() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        for (Contact c : contacts) {
            if (c.getContactId().equals(contact.getContactId())) {
                throw new IllegalArgumentException("Contact ID already exists");
            }
        }
        contacts.add(contact);
    }

    public void deleteContact(String contactId) {
        contacts.removeIf(c -> c.getContactId().equals(contactId));
    }

    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        for (Contact c : contacts) {
            if (c.getContactId().equals(contactId)) {
                if (firstName != null && firstName.length() <= 10) {
                    c.setFirstName(firstName);
                }
                if (lastName != null && lastName.length() <= 10) {
                    c.setLastName(lastName);
                }
                if (phone != null && phone.length() == 10) {
                    c.setPhone(phone);
                }
                if (address != null && address.length() <= 30) {
                    c.setAddress(address);
                }
                return;
            }
        }
    }

    public Contact getContact(String contactId) {
        for (Contact c : contacts) {
            if (c.getContactId().equals(contactId)) {
                return c;
            }
        }
        return null;
    }
}
