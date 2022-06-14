# testDomotica
Repository for a simple Java home automation program based on oneM2M standard, using oneM2M Mobius platform and Device simulator.

Con questo semplice progetto è possibile ottenere un banale scenario di domotica sfruttando la piattaforma OneM2M Mobius e il OneM2M Device Simulator: basterà poi eseguire
il file MainDomotica.java.

Per installare la piattaforma OneM2M Mobius si faccia riferimento alle slides 104 del tutorial avanzato OneM2M.
Sinteticamente, ciò che occorre fare è: installare MySQL, Mosquitto e Node.js seguendo le indicazioni di tale slides per poi in seguito clonare la repository
relativa al codice sorgente Mobius all'inidirizzo https://github.com/IoTKETI/Mobius. In seguito, installare Postman e il browser OneM2M all'indirizzo https://github.com/IoTKETI/oneM2MBrowser,
utili ai fini di testing e comprensione della piattaforma.

Oltre a ciò è necessario clonare la repository per il Device Simualator OneM2M a seguente link https://github.com/IoTKETI/oneM2M-Device_Simulator.git.
Dopo aver fatto ciò, recarsi da tramite prompt nella cartella appena clonata, installare i moduli OneM2M necessari attraverso il comando "npm install"
e eseguire il Device Simulator attraverso il comando "node app.js": sarà possibile utilizzare il device alla porta 8369 dell' host locale (indirizzo http://127.0.0.1:8369/). 
Questo ultimo passo è da svolgersi ogni volta dopo l'avvio della piattaforma Mobius.
In ogni caso, anche per questa parte si rimanda alle slides 105 del tutorial avanzato OneM2M.

Dopo aver soddisfatto questi due requisiti, collegandosi all'indirizzo di cui sopra, è necessario creare almeno i seguenti dispositivi virtuali: un termometro, 
un buzzer che indica lostato del riscaldamento (acceso o spento), delle lampadine che indicano quante luci sono presenti nella stanza 
(quantità di esse a discrezione dell'utilizzatore) e un sensore di presenza.
Fatto ciò eseguendo il file MainDomotica.java si ottiene una gestione dei dispositivi creati: in base alla presenza o meno di qualcuno nella stanza le luci si accendono o spengono
mentre il riscaldamento viene acceso al di sotto deic 19 °C e spento al di sopra dei 22 °C.



