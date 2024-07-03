;;; Sierra Script 1.0 - (do not remove this comment)
(script# 500)
(include sci.sh)
(use Main)
(use LLRoom)
(use Door)
(use Class_255_0)
(use Polygon)
(use CueObj)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm500 0
)

(local
	local0
)
(instance rm500 of LLRoom
	(properties
		picture 500
		north 510
	)
	
	(method (init)
		(switch gGNumber
			(north
				(gLongSong fade: 80 10 10 0)
				(gLarry init: normalize: edgeHit: 0)
			)
			(else 
				(gLongSong number: 0 stop:)
				(gLarry
					init:
					normalize:
					posn: 24 177 0
					setLoop: -1
					setHeading: 180
					edgeHit: 0
				)
				(limo init:)
				(= global160 1)
				(global2 setScript: sExitLimo)
			)
		)
		(super init:)
		(door init: approachVerbs: 3)
		(doorR init: approachVerbs: 3)
		(if (or (== gGNumber 200) (proc0_6 1))
			(limo init: approachVerbs: 3)
		)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						145
						143
						124
						157
						32
						157
						32
						147
						72
						147
						73
						145
						3
						145
						3
						165
						315
						165
						315
						145
						261
						145
						260
						147
						295
						147
						295
						156
						205
						156
						190
						143
						158
						143
						151
						0
						319
						0
						319
						189
						0
						189
						0
						0
						148
						0
					yourself:
				)
		)
		(lavaLamp1 init:)
		(lavaLamp2 init:)
		(plants1 init:)
		(plants2 init:)
	)
	
	(method (doit)
		(super doit:)
		(if (not (mod (++ local0) 10)) (Palette 6 239 254 -1))
		(cond 
			(script)
			((and (proc0_5 gLarry 2) (not (proc0_6 105))) (proc0_2) (global2 setScript: sPiss))
		)
	)
	
	(method (doVerb theVerb)
		(return
			(switch theVerb
				(2 (proc0_14 500 0) (return 1))
				(3
					(cond 
						((== gGNumber 200) (proc0_14 500 1))
						((proc0_6 1) (proc0_14 500 2))
						(else (proc0_14 500 3))
					)
					(return 1)
				)
				(else 
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance sPiss of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_10 1 105)
				(= seconds 3)
			)
			(1
				(proc0_18 gLarry 500 4)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance sExitLimo of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0 (= cycles 2))
			(1
				(proc0_2)
				(gLongSong2 number: 191 setLoop: 1 play:)
				(= ticks 50)
			)
			(2
				(gLarry
					setLoop: 3
					setCel: 0
					setMotion: MoveTo 24 163 self
				)
			)
			(3
				(gLarry setLoop: -1 setHeading: 180)
				(= ticks 10)
			)
			(4
				(gLongSong2 number: 192 setLoop: 1 play:)
				(= ticks 110)
			)
			(5
				(WrapMusic firstSound: 500 lastSound: 502)
				(gLongSong
					number: 500
					play: WrapMusic
					setVol: 80
					flags: 1
					setLoop: 1
				)
				(self setScript: sLimoLeaves self)
			)
			(6
				(proc0_3)
				(limo dispose:)
				(= cycles 1)
			)
			(7
				(gLarry normalize:)
				(self dispose:)
				(if
					(proc255_0
						500
						5
						81
						{Uložit}
						1
						81
						{Ne, proè se obtìžovat?}
						0
						80
						{AL øíká}
						67
						-1
						20
					)
					(gGame save:)
				)
			)
		)
	)
)

(instance sEnterLimo of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry setLoop: -1 setHeading: 180 self)
			)
			(1
				(gLongSong2 number: 191 setLoop: 1 play:)
				(= ticks 50)
			)
			(2
				(gLarry setMotion: MoveTo 23 183 self)
			)
			(3 (gLarry hide:) (= ticks 10))
			(4
				(gLongSong2 number: 192 setLoop: 1 play:)
				(= ticks 110)
			)
			(5
				(self setScript: sLimoLeaves self)
			)
			(6 (global2 newRoom: 200))
		)
	)
)

(instance sLimoLeaves of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (== (gLongSong2 prevSignal?) 10)
			(gLongSong2 prevSignal: 0)
			(self cue:)
		)
	)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gLongSong2 number: 194 setLoop: 1 play:)
			)
			(1
				(limo setStep: 2 2 setMotion: MoveTo 67 (limo y?) self)
			)
			(2
				(limo setStep: 4 4 setMotion: MoveTo 45 (limo y?) self)
			)
			(3
				(limo setStep: 6 6 setMotion: MoveTo 15 (limo y?) self)
			)
			(4
				(limo setStep: 9 9 setMotion: MoveTo -25 (limo y?) self)
			)
			(5
				(limo
					setStep: 12 12
					setMotion: MoveTo -95 (limo y?) self
				)
			)
			(6 (self dispose:))
		)
	)
)

(instance limo of Actor
	(properties
		x 75
		y 189
		description {tvoje limuzína}
		approachX 23
		approachY 163
		lookStr {Proè všechny ty limuzíny vypadají stejnì?}
		view 500
		priority 14
		signal $4810
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(3
				(proc0_2)
				(gLongSong fade:)
				(global2 setScript: sEnterLimo)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance doorR of Feature
	(properties
		x 188
		y 98
		nsTop 56
		nsLeft 168
		nsBottom 141
		nsRight 209
		description {vstupní dveøe}
		sightAngle 40
		approachX 154
		approachY 144
		lookStr {Kdybys pøišel na to, jak otevøít tyhle dveøe, mohl bys vstoupit do "Kavárny Hard Disk Café".}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (door open:))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance door of Door
	(properties
		x 146
		y 141
		description {vstupní dveøe}
		sightAngle 40
		approachX 154
		approachY 144
		lookStr {Kdybys pøišel na to, jak otevøít tyhle dveøe, mohl bys vstoupit do "Kavárny Hard Disk Café".}
		view 500
		loop 2
		entranceTo 510
		moveToX 156
		moveToY 135
		enterType 0
		exitType 0
	)
)

(instance lavaLamp1 of Feature
	(properties
		x 76
		y 97
		nsTop 41
		nsLeft 41
		nsBottom 153
		nsRight 111
		description {lávová lampa}
		sightAngle 40
		onMeCheck $0008
		lookStr {Páni! Obøí lávová lampa! (Tyhle vìci jsi vždycky miloval!)}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 500 6))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance lavaLamp2 of Feature
	(properties
		x 256
		y 93
		nsTop 33
		nsLeft 220
		nsBottom 154
		nsRight 292
		description {lávová lampa}
		sightAngle 40
		onMeCheck $0008
		lookStr {Páni! Obøí lávová lampa! (Tyhle vìci jsi vždycky miloval!)}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 500 6))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance plants1 of Feature
	(properties
		x 76
		y 97
		nsTop 41
		nsLeft 41
		nsBottom 153
		nsRight 111
		description {rostlina}
		sightAngle 40
		onMeCheck $0004
		lookStr {Navzdory atmosféøe tady tyhle rostliny rostou.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance plants2 of Feature
	(properties
		x 256
		y 93
		nsTop 33
		nsLeft 220
		nsBottom 154
		nsRight 292
		description {rostlina}
		sightAngle 40
		onMeCheck $0004
		lookStr {Navzdory atmosféøe tady tyhle rostliny rostou.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)
