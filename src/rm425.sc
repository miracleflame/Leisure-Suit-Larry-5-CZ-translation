;;; Sierra Script 1.0 - (do not remove this comment)
(script# 425)
(include sci.sh)
(use Main)
(use LLRoom)
(use Door)
(use Polygon)
(use CueObj)
(use n958)
(use Sound)
(use Cycle)
(use Obj)

(public
	rm425 0
)

(instance rm425 of LLRoom
	(properties
		lookStr {Stoj� p�ed budovou FBI, kter� je chyt�e zamaskovan� jako blok norm�ln�ch obchod�. U chodn�ku na tebe �ek� tv� limuz�na, p�esn� jak Desmond sl�bil.}
		picture 425
		north 435
	)
	
	(method (init)
		(proc958_0 132 191 192)
		(gLarry init: normalize: 572 edgeHit: 0)
		(switch gGNumber
			(north 0)
			(200
				(gLarry
					x: (limo approachX?)
					y: (+ (limo approachY?) 10)
					hide:
				)
				(proc0_2)
				(self setScript: sFromLimo)
			)
			(else 
				(gLarry posn: 160 160)
				(proc0_3)
			)
		)
		(super init:)
		(door init:)
		(limo init: approachVerbs: 3)
		(steinSign init:)
		(steinLabs init:)
		(gynoSign init:)
		(gynoBuilding init:)
		(woodwindSign init:)
		(woodwindBuilding init:)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						0
						184
						0
						185
						153
						12
						153
						12
						156
						305
						156
						305
						153
						195
						153
						195
						0
						319
						0
						319
						189
						0
						189
					yourself:
				)
		)
	)
)

(instance sLimo of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= ticks 150))
			(1
				(soundFX number: 191 play:)
				(= ticks 50)
			)
			(2 (= ticks 60))
			(3
				(gLarry
					setCycle: 0
					setCel: (gLarry cel?)
					setLoop: (gLarry loop?)
					setMotion: MoveTo (gLarry x?) (+ (gLarry y?) 10) self
				)
			)
			(4 (gLarry hide:) (= ticks 60))
			(5
				(soundFX number: 192 play:)
				(= ticks 100)
			)
			(6 (global2 newRoom: 200))
		)
	)
)

(instance sFromLimo of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 3))
			(1
				(soundFX number: 191 play:)
				(= ticks 50)
			)
			(2 (= ticks 60))
			(3
				(gLarry
					show:
					setLoop: 3
					setCel: (gLarry cel?)
					setMotion: MoveTo (gLarry x?) (- (gLarry y?) 10) self
				)
			)
			(4
				(gLarry normalize: 572 setHeading: 180 self)
			)
			(5 (= ticks 60))
			(6
				(soundFX number: 192 play:)
				(= ticks 100)
			)
			(7 (proc0_3) (self dispose:))
		)
	)
)

(instance door of Door
	(properties
		x 193
		y 151
		description {dve�e}
		approachX 188
		approachY 156
		lookStr {Tyto dve�e vedou zp�t do FB... Ups! Tyhle dve�e vedou do "Steinov�ch laborato��!"}
		view 425
		entranceTo 435
		moveToX 188
		moveToY 150
		enterType 0
		exitType 0
	)
)

(instance limo of Feature
	(properties
		x 72
		y 158
		nsTop 146
		nsLeft 3
		nsBottom 171
		nsRight 161
		description {tv� limuz�na}
		sightAngle 40
		approachX 72
		approachY 156
		lookStr {Tv� limuz�na t� o�ek�v�.}
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(3
				(proc0_2)
				(global2 setScript: sLimo)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance steinSign of Feature
	(properties
		x 133
		y 148
		z 27
		nsTop 108
		nsLeft 101
		nsBottom 134
		nsRight 166
		description {n�pis Stein Labs}
		sightAngle 40
		lookStr {Velk� cedule ozna�uje laborato�e FBI jako "Steinovy laborato�e - budeme s v�mi up��mn�".}
	)
)

(instance steinLabs of Feature
	(properties
		x 165
		y 93
		nsTop 37
		nsLeft 92
		nsBottom 150
		nsRight 238
		description {Steinovy laborato�e}
		sightAngle 40
		lookStr {Nel�b� se ti, �e FBI m� smysl pro humor?}
	)
)

(instance gynoSign of Feature
	(properties
		x 63
		y 146
		z 47
		nsTop 76
		nsLeft 55
		nsBottom 123
		nsRight 71
		description {n�pis GynoMan}
		sightAngle 40
		lookStr {Kancel�� doktora Phila Hopiana je chyt�e maskov�na jako "GynoMan".}
	)
)

(instance gynoBuilding of Feature
	(properties
		x 45
		y 102
		nsTop 58
		nsBottom 146
		nsRight 91
		description {budova GynoMan}
		sightAngle 40
		lookStr {Zaj�malo by t�, jak� kancel��e jsou v horn�ch patrech t�to budovy nad ordinac� doktora Phila Hopiana.}
	)
)

(instance woodwindBuilding of Feature
	(properties
		x 278
		y 98
		nsTop 45
		nsLeft 238
		nsBottom 151
		nsRight 319
		description {budova opravovny Woodwind}
		sightAngle 40
		lookStr {Opravovna Woodwind je neobvykl� kryt� pro kancel�� FBI.}
	)
)

(instance woodwindSign of Feature
	(properties
		x 286
		y 151
		z 73
		nsTop 66
		nsLeft 254
		nsBottom 91
		nsRight 319
		description {n�pis Opravovna Woodwind}
		sightAngle 40
		lookStr {Opravovna Woodwind m� p�ed domem atraktivn� n�pis.}
	)
)

(instance soundFX of Sound
	(properties)
)
