# Leisure-Suit-Larry-5-CZ-translation


fon - fonty upravené s pridanými znakmi pre češtinu, importujú sa do resource súborov hry pomocou SCI Companiona

scr - .txt určené na preklad obsahujú vyextrahované stringy z .sc súborov, Slávek ich následne skriptom hromadne prevádza do .sc, ktoré sa importujú do resource súborov hry pomocou SCI Companiona

tex - Obsahuje dialógové textové súbory s príponou .cs5 určené na preklad, tieto sa následne preložené posielajú Slávkovi na hromadný prevod do .tex súborov, a tie sa importujú do resource súborov hry pomocou SCI Companiona

v56 - súbory grafiky, importujú sa do resource súborov hry pomocou SCI Companiona

SCI Companion: https://github.com/Kawa-oneechan/SCICompanion/releases/tag/v3.2.4.0 ( home: http://sciwiki.sierrahelp.com//index.php?title=SCI_Companion )

Rekompilace archivu resource.000:

File/Open Game... -> resource.map
Script/Manage Decompilation -> select all -> Decompile
nahradit soubory
Script/Compile all
a naknec prepsat nove vznikle soubory resource.map a resource.000 do hry (teoreticky)
