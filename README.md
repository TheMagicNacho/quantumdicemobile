# quantumdicemobile
###Android UI for the quantum dice engine.
NOW YOU CAN PLAY WITH A QUANTUM DEVICE ON YOUR PHONE!
With Q-Dice literally, all possibilities exist, and a single measurable outcome is provided!
The Quantum Dice mobile app uses IBM’s Qiskit, which leverages a quantum CPU, to generate a truly random set of numbers.

##Background
My brother taught me how to play ‘Dungeons and Dragons’ over 2018 Christmas, but I noticed that all the dice apps sucked. 
The apps I found were clunky and slow. So develop my very own app using python.

While creating the first dice app, I learned about how classical computing can only generate pseudo-random numbers. To overcome the pseudo-random restriction of a classical computer, I created a quantum random number engine using Qiskit from IBM.

##Implementation
To bring the quantum engine into a user-friendly mobile device, we had to compile the python engine on Android using the Python to Android SDK. Click here to learn more about implementing Python on Android.

##Quantum Simulations vs. Pure Qbits
To save on resourcing and calculation times, the mobile app is limited to using the IBM Qbit simulators. My experiments with the IBMQX4 Backend proved that the infrastructure is not ready for mass market usage because of the significant costs associated.

We will publish a white paper on how to adapt the current random engine to utilize the actual IBM Q experience cloud.

My hope is by developing this process and releasing it for public use, other developers and scientists will be inspired to bring the quantum cloud closer to end-users.

## Credit
@misc{ Qiskit,
       author = {Gadi Aleksandrowicz and Thomas Alexander and Panagiotis Barkoutsos and Luciano Bello and Yael Ben-Haim and David Bucher and Francisco Jose Cabrera-Hern{\'a}ndez and Jorge Carballo-Franquis and Adrian Chen and Chun-Fu Chen and Jerry M. Chow and Antonio D. C{\'o}rcoles-Gonzales and Abigail J. Cross and Andrew Cross and Juan Cruz-Benito and Chris Culver and Salvador De La Puente Gonz{\'a}lez and Enrique De La Torre and Delton Ding and Eugene Dumitrescu and Ivan Duran and Pieter Eendebak and Mark Everitt and Ismael Faro Sertage and Albert Frisch and Andreas Fuhrer and Jay Gambetta and Borja Godoy Gago and Juan Gomez-Mosquera and Donny Greenberg and Ikko Hamamura and Vojtech Havlicek and Joe Hellmers and {\L}ukasz Herok and Hiroshi Horii and Shaohan Hu and Takashi Imamichi and Toshinari Itoko and Ali Javadi-Abhari and Naoki Kanazawa and Anton Karazeev and Kevin Krsulich and Peng Liu and Yang Luh and Yunho Maeng and Manoel Marques and Francisco Jose Mart{\'\i}n-Fern{\'a}ndez and Douglas T. McClure and David McKay and Srujan Meesala and Antonio Mezzacapo and Nikolaj Moll and Diego Moreda Rodr{\'\i}guez and Giacomo Nannicini and Paul Nation and Pauline Ollitrault and Lee James O'Riordan and Hanhee Paik and Jes{\'u}s P{\'e}rez and Anna Phan and Marco Pistoia and Viktor Prutyanov and Max Reuter and Julia Rice and Abd{\'o}n Rodr{\'\i}guez Davila and Raymond Harry Putra Rudy and Mingi Ryu and Ninad Sathaye and Chris Schnabel and Eddie Schoute and Kanav Setia and Yunong Shi and Adenilton Silva and Yukio Siraichi and Seyon Sivarajah and John A. Smolin and Mathias Soeken and Hitomi Takahashi and Ivano Tavernelli and Charles Taylor and Pete Taylour and Kenso Trabing and Matthew Treinish and Wes Turner and Desiree Vogt-Lee and Christophe Vuillot and Jonathan A. Wildstrom and Jessica Wilson and Erick Winston and Christopher Wood and Stephen Wood and Stefan W{\"o}rner and Ismail Yunus Akhalwaya and Christa Zoufal},
       title = {Qiskit: An Open-source Framework for Quantum Computing},
       year = {2019},
       doi = {10.5281/zenodo.2562110}
}
@chaquo/
