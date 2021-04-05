import java.io.*;
import java.net.*;
import java.util.*;

public class AxurChallenge {
	public static void main(String[] args) throws Exception {
		String[] search = { "senha", "senh@", "senhas", "senh@s", "promo", "promoção", "promocão", "promoçao",
                                "promocao", "promoç@o", "promoc@o", "promoções", "promocões", "promoçoes", "promocoes",
                                "black friday", "bl@ck friday", "black frid@y", "bl@ck frid@y", "blackfriday", "bl@ckfriday",
                                "blackfrid@y", "bl@ckfrid@y", "password" };

		int numberOfSearches = search.length;

		String suspiciousMsg = "suspicious";
		String safeMsg = "safe";

		URL url = new URL(args[0]);
		Scanner scanner = new Scanner(url.openStream());

		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			for (int i = 0; i < numberOfSearches; i++) {
				if (line.toLowerCase().contains(search[i])) {
					System.out.println(suspiciousMsg);
					System.exit(1);
				}
			}
		}

		System.out.println(safeMsg);
	}
}
