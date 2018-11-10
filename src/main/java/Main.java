import java.text.ChoiceFormat;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

	public static void main(String[] args) {
		Locale locale = Locale.forLanguageTag("nl");
		ResourceBundle translations = ResourceBundle.getBundle("translations", locale);

		String name = "Alex";

		String greetings = translations.getString("greetings");
		String formattedMessage = MessageFormat.format(greetings, name);

		System.out.println(formattedMessage);


		String messages = translations.getString("messages");
		String plural = translations.getString("message_plural");
		String singular = translations.getString("message_singular");

		double[] limits = {0, 1, 2};
		String[] choices = {singular, singular, plural};
		ChoiceFormat choiceFormat = new ChoiceFormat(limits, choices);

		MessageFormat messageFormat = new MessageFormat(messages, locale);
		messageFormat.setFormatByArgumentIndex(1, choiceFormat);

		int count = 2;
		Object[] arguments = {count, count};

		String formattedMessages = messageFormat.format(arguments);
		System.out.println(formattedMessages);
	}
}
