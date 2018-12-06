
// Hello World! ////////////////////////////////////////////////////////////////

// modulate a sine frequency and a noise amplitude with another sine
// whose frequency depends on the horizontal mouse pointer position
(
{
        var x = SinOsc.ar(MouseX.kr(1, 100));
        SinOsc.ar(300 * x + 800, 0, 0.1)
        +
        PinkNoise.ar(0.1 * x + 0.1)
}.play;
)

// Synth Defs /////////////////////////////////////////////////////////////////
(
SynthDef(\irfs,{ arg freq=440, amp=0.5, pan=0.0;
	var env;

	env = EnvGen.ar( Env([0,1,1,0],[0.01, 0.1, 0.2]),  doneAction:2);

	Out.ar(0,  Pan2.ar(Blip.ar(freq) * env * amp, pan))
}).add;
)

// accepts defaults. Synth shouldn't hang around once envelope finished due to doneAction:2
Synth(\irfs);


// specifying values
Synth(\irfs,[\freq,880,\amp,0.2,\pan,1.0]) //pan 1.0 should send to right ear




// Sequencing ////////////////////////////////////////////////////////////////
(
{
	8.do {
        // Synth(\irfs); // change the Def on the fly
        Synth(\event,[\freq, rrand(440, 880)]); // randomise params
		1.0.wait;
	};
}.fork;
)

// UI  ////////////////////////////////////////////////////////////////////////

(
{
	[
	LFNoise0.ar(100),	//step
	LFNoise1.ar(100),	//linear interpolation
	LFNoise2.ar(100)	//quadratic interpolation
	]
}.plot(0.1)
)

// Open FM Synth

