# Delivery_of_Services
Membrii echipei: Ivașcu Ionela, Ianoșiga Nicoleta

Descriere generală: Scopul aplicației este cel de a pune în legătură persoanele care oferă servicii și persoanele care doresc să obțină servicii. 

Înregistrarea va fi disponibilă atât pentru provider cât și pentru customer. Pentru a-și crea un cont este nevoie de introducerea unui username și a unei parole, urmând să își selecteze un rol în fucție de serviciile pe care le dorește sau pe care dorește să le presteze.

O dată creat contul, user-ul trebuie să se intre în aplicație folosind username-ul și parola pe care le-a introdus când și-au creat contul.

Un Provider logat poate crea anunțuri, iși poate modifica username-ul și parola accesând update din pagina de profil își poate vedea anunțurile și request-urile primite de la customeri pe care le pot accepta sau respinge si un provider iși mai poate șterge anunțurile.

Un Customer logat poate vedea anunțuri din diferite domenii, le poate da un request, iși poate modifica username-ul și parola din profil dand update, își poate vedea istoria anuțurilor cărora le-a dat request, și mai poate vedea statusul dupa aprobarea sau respingerea cererii anunțului de către provider.

Pentru crearea proiectului am folosit Maven, Java Fx, iar ca bază de date Nitrite.

Pentru rularea aplicației, un utilizator trebuie să o cloneze, iar apoi să scrie în terminal  comanda "mvn clean install" și "mvn javafx:run".
