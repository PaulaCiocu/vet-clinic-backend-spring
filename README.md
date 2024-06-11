Vet Clinic Java/Spring/JPA

- appointment : tabelul pentru programari : 
                                 -id
                                 - nume animal
                                 - data
                                 - nume doctor 
                                 - service ids ( o lista cu id-urile tuturor serviciilor)
- appointment service : - init() - initializeaza 5 programri si 6 servicii 
                                - getFilteredAppointments returneaza programarile in functie de filtru
                                - getAllAppointments returneaza toate programarile
                                - save 
                                - update
- doctorservice: tabel pentru servicii:
                                -id
                                - nume
                                - pret
- doctorservice service:        - findAll returneaza toate programarile
                                - save
- user - tabelul numit users contine:
                                - id
                                - nume
                                -parola
- user service:               -init()  initializeaza 2 conturi
                                - getUseer- returneaza toti userii
                                - getuserbyid -returneaza userul in functie de id
                                - createuser
- saved searches:               - id
                                - nume
                                - lista de filtre (filterKey - classa care are 2 atribute: coloana si valorare pentru filtre de exemplu status=COMPLETED)
                                - lista de criterii de sortare ( sortCriteria - clasa cu 2 atribute : coloana si directie pentru sortare de exemplu sort=status,asc)
                                - list vizibilitate coloane (columnVisibility - clasa cu 2 atribute coloana si un boolean care este true daca userul doreste sa fie vizibila coloana si false altfel)

- saved searches service:       - initializeaza cate o salvare pentru fiecare user predefinit
                                - getAllSavedSearches returneaza toate salvarile
                                - save
                                
  


                                
