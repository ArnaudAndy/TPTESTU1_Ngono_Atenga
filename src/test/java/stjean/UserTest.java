package stjean;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
class UserTest {

    @org.junit.jupiter.api.Test
    void add() {
    }

    @org.junit.jupiter.api.Test
    void delete() {
    }

    @org.junit.jupiter.api.Test
    void list() {
    }

    @org.junit.jupiter.api.Test
    void display() {
    }

    @BeforeEach
    public void setUp() throws EmailInvalidException {
        User.users.clear();
        User.add(new User(1, "Alice", 28, "alice@example.com", "1234567890", "New York", 1500.0));
        User.add(new User(2, "Bob", 35, "bob@example.com", "1234567891", "Los Angeles", 2500.0));
        User.add(new User(3, "Charlie", 30, "charlie@example.com", "1234567892", "Chicago", 1000.0));
        User.add(new User(4, "Diana", 40, "diana@example.com", "1234567893", "Miami", -500.0)); // Negative balance for testing

    }

    @Test
    public void testAddUserWithValidEmail() throws EmailInvalidException {
        User user = new User(1, "John Doe", 30, "john.doe@example.com", "1234567890", "New York", 1000.0);
        User.add(user);
        assertEquals(1, User.users.size());
        assertEquals(user, User.users.get(0));
    }

    @Test
    public void testAddUserWithInvalidEmail() {
        Exception exception = assertThrows(EmailInvalidException.class, () -> {
            User user = new User(2, "Jane Doe", 25, "ngono.arnaud@invalid", "0987654321", "Douala", 500.0);
            User.add(user);
        });
        assertEquals("Invalid email format: ngon.arnaud@invalid", exception.getMessage());
    }

    @Test
    public void testDeleteUserSuccessfully() throws EmailInvalidException, DeletionInvalidException {
        User user = new User(3, "Alice Smith", 28, "alice.smith@example.com", "1122334455", "Chicago", 1500.0);
        User.add(user);
        User.delete(3);
        assertEquals(0, User.users.size());
    }

    @Test
    public void testDeleteNonExistentUser() {
        Exception exception = assertThrows(DeletionInvalidException.class, () -> {
            User.delete(999);
        });
        assertEquals("No user found with ID: 999", exception.getMessage());
    }

    @Test
    public void testListUsers() throws EmailInvalidException {
        User user1 = new User(4, "Bob Brown", 40, "bob.brown@example.com", "2233445566", "Miami", 2000.0);
        User user2 = new User(5, "Charlie Green", 35, "charlie.green@example.com", "3344556677", "Seattle", 2500.0);
        User.add(user1);
        User.add(user2);



        User.list();


    }

    @Test
    public void testDisplayUserSuccessfully() throws EmailInvalidException {
        User user = new User(6, "Dave White", 45, "dave.white@example.com", "4455667788", "Austin", 3000.0);
        User.add(user);


        User.display(6);


    }

    @Test
    public void testDisplayNonExistentUser() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            User.display(999);
        });
        assertEquals("No user found with ID: 999", exception.getMessage());
    }

    @BeforeEach


    @Test
    public void testAnalyseSoldeGeneral() {
        try {
            double totalBalance = User.analyseSoldeGeneral();
            assertEquals(3500.0, totalBalance, 0.01);
        } catch (NegativeGeneralBalanceException e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testAnalyseSoldeGeneralThrowsException() throws EmailInvalidException {
        User.users.clear(); // Clear users list
        User.add(new User(5, "Eve", 22, "eve@example.com", "1234567894", "Seattle", -1000.0)); // Only negative balance

        Exception exception = assertThrows(NegativeGeneralBalanceException.class, () -> {
            User.analyseSoldeGeneral();
        });

        assertEquals("Negative general balance: -1000.0", exception.getMessage());
    }

    @Test
    public void testGetRichestUser() {
        User richestUser = User.getRichestUser();
        assertNotNull(richestUser);
        assertEquals("Bob", richestUser.getName());
        assertEquals(2500.0, richestUser.getBalancePersonnel(), 0.01);
    }

    @Test
    public void testGetRichestUserWhenNoUsers() {
        User.users.clear(); // Clear the users list
        User richestUser = User.getRichestUser();
        assertNull(richestUser); // Should return null if no users exist
    }
}
