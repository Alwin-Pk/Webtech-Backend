package de.htw.backend;

import de.htw.backend.persistence.GuestEntity;
import de.htw.backend.persistence.GuestRepository;
import de.htw.backend.service.GuestService;
import de.htw.backend.web.api.Guest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
class BackendApplicationTests
{

	@Autowired
	private GuestService guestServiceTest;

	@MockBean
	private GuestRepository guestRepositoryTest;

	@Test
	@DisplayName("Simple toString test, should return the GuestEntity object as a String")
	void testGuestEntityToString()
	{
		var g1 = new GuestEntity(
				"12345",
				"Pekala",
				"Alwin",
				"s0579159@htw-berlin.de",
				"25.05.2022");
		g1.setId(0L);

		String expected = "GuestEntity{" +
				"id=" + "0" +
				", telefonNummer='" + "12345" + '\'' +
				", lastName='" + "Pekala" + '\'' +
				", firstName='" + "Alwin" + '\'' +
				", emailAdresse='" + "s0579159@htw-berlin.de" + '\'' +
				", date='" + "25.05.2022" + '\'' +
				'}';

		assertEquals(expected, g1.toString());
	}

	@Test
	@DisplayName("Should find a guest by its id and return the first name")
	void testGuestEntity()
	{
		var g1 = new GuestEntity(
						   "12345",
						   "Pekala",
						   "Alwin",
						   "s0579159@htw-berlin.de",
						   "25.05.2022");
		//Warum zwei GuestEntities wenn wir nur eine vergleichen?
		var g2 = new GuestEntity(
						   "67890",
						   "Mustermann",
						   "Max",
						   "max.mustermann@test.de",
						   "25.05.2022");

		g1.setId(1L);
		g2.setId(2L);

		doReturn(Optional.of(g1)).when(guestRepositoryTest).findById(1L);
		doReturn(Optional.of(g2)).when(guestRepositoryTest).findById(2L);

		Guest acutal = guestServiceTest.get(1L);

		assertEquals("Alwin", acutal.getFirstName());
	}
}
