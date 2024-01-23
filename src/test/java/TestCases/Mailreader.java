package TestCases;

import java.net.URI;

import org.testng.annotations.Test;

import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.enumeration.property.WellKnownFolderName;
import microsoft.exchange.webservices.data.core.service.folder.Folder;
import microsoft.exchange.webservices.data.core.service.item.EmailMessage;
import microsoft.exchange.webservices.data.core.service.item.Item;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.search.FindItemsResults;
import microsoft.exchange.webservices.data.search.ItemView;

public class Mailreader {
	@Test
	
	public void readEmail() throws Exception {
	ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2010_SP2); // This is the latest version of this library

	ExchangeCredentials credentials = new WebCredentials("sakthikaveri35@hotmail.com", "Skaveri@12346");
	service.setCredentials(credentials);
	// this.exchangeService.setWebProxy(new WebProxy("xx.xxx.xxx.xx", 8080)); // If you're behind a proxy
	service.setUrl(new URI("https://outlook.office365.com/EWS/Exchange.asmx")); // This is the standard URL

	Folder inboxFolder = Folder.bind(service, WellKnownFolderName.Inbox);

	FindItemsResults<Item> results = service.findItems(inboxFolder.getId(), new ItemView(10)); // 10 is the number of items to fetch (pagesize)

	for (Item result : results)
	{
	    EmailMessage currentEmail = (EmailMessage) result;

	    System.out.println(currentEmail.getFrom());
	    // And so on
	}

}
}
