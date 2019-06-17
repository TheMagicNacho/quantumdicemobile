# The Quantum Dice Mobile (Q-Dice)
### Android UI for the quantum dice engine.
Read the documentation: [Website](https://www.artemisorbitals.com/products/thequantumdice).

NOW YOU CAN PLAY WITH A QUANTUM DEVICE ON YOUR PHONE!
With Q-Dice literally, all possibilities exist, and a single measurable outcome is provided!
The Quantum Dice mobile app uses IBM’s Qiskit, which leverages a quantum CPU, to generate a truly random set of numbers.

## Background
My brother taught me how to play ‘Dungeons and Dragons’ over 2018 Christmas, but I noticed that all the dice apps sucked. 
The apps I found were clunky and slow. So develop my very own app using python.

While creating the first dice app, I learned about how classical computing can only generate pseudo-random numbers. To overcome the pseudo-random restriction of a classical computer, I created a quantum random number engine using Qiskit from IBM.

## Implementation
To bring the quantum engine into a user-friendly mobile device, we had to compile the python engine on Android using the Python to Android SDK. Click here to learn more about implementing Python on Android.

## Quantum Simulations vs. Pure Qbits
To save on resourcing and calculation times, the mobile app is limited to using the IBM Qbit simulators. My experiments with the IBMQX4 Backend proved that the infrastructure is not ready for mass market usage because of the significant costs associated.

We will publish a white paper on how to adapt the current random engine to utilize the actual IBM Q experience cloud.

My hope is by developing this process and releasing it for public use, other developers and scientists will be inspired to bring the quantum cloud closer to end-users.

## Credit
@qiskit
@chaquo
