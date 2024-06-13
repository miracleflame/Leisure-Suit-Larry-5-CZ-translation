;;; Sierra Script 1.0 - (do not remove this comment)
(script# 250)
(include sci.sh)
(use Main)
(use LLRoom)
(use Door)
(use Polygon)
(use CueObj)
(use Sound)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm250 0
)

(local
	local0
	local1
)
(instance rm250 of LLRoom
	(properties
		picture 250
		north 270
	)
	
	(method (init)
		(proc0_2)
		(Load rsVIEW 250)
		(gLarry init: normalize: 553 setStep: 2 1)
		(plane
			init:
			setLoop: 0
			setCel: (Random 4 6)
			setScript: sPlane
		)
		(door init: setPri: 4)
		(if (or (proc0_6 38) (proc0_6 1))
			(limo init: posn: 277 115)
		)
		(switch gGNumber
			(north
				(gLarry edgeHit: 0)
				(proc0_17 5 1 global2)
			)
			(258
				(gLarry posn: 191 105 illegalBits: -32768)
				(proc0_17 5 1 global2)
			)
			(else 
				(gLarry posn: 1000 1000 0)
				(if (not (proc0_6 38))
					(if (not (gCast contains: limo)) (limo init:))
					(limo posn: 400 115)
				)
				(global2 setScript: sLimo)
			)
		)
		(super init:)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						0
						257
						0
						257
						104
						182
						104
						182
						106
						315
						106
						316
						104
						263
						104
						263
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
		(otherDoor init:)
		(driveway init:)
		(car init:)
		(car2 init:)
		(luggage init:)
		(luggage2 init:)
		(bush init:)
		(tower init:)
		(ATM init: approachVerbs: 3 4)
		(trashCan init: approachVerbs: 3)
		(if
			(and
				(proc0_6 12)
				(== global160 3)
				(not (gLarry has: 21))
				(not (proc0_6 11))
			)
			(envelope init: approachVerbs: 3)
			(= local0 1)
		)
		(gAddToPics doit:)
		(cloud
			init:
			setCel: 8
			posn: (Random 90 230) (Random 1 20) -30
			stopUpd:
		)
		(theSign init: setCel: global160 setPri: 4)
		(gLongSong number: 251 loop: -1 play:)
	)
	
	(method (doit)
		(super doit:)
		(if script (script doit:))
	)
	
	(method (doVerb theVerb param2 &tmp [temp0 100])
		(switch theVerb
			(2
				(if local0
					(proc0_14 250 0)
				else
					(Format
						@temp0
						250
						1
						(switch global160
							(0 {Los Angeles})
							(1 {New York})
							(2 {Atlantic City})
							(3 {Miami})
						)
					)
					(proc0_14 @temp0)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (cue)
		(proc0_3)
	)
	
	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 258)
			(gLongSong stop:)
			(gLongSong2 stop:)
			(theMusic3 stop:)
		else
			(gLongSong2 fade:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance ATM of Feature
	(properties
		y 1
		nsTop 82
		nsLeft 176
		nsBottom 94
		nsRight 190
		description {bankomat}
		sightAngle 40
		approachX 189
		approachY 102
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 250 2))
			(3 (global2 newRoom: 258))
			(5
				(proc0_14 250 3)
				(proc0_14 250 4)
			)
			(4
				(switch param2
					(7
						(gLarry put: 7)
						(global2 newRoom: 258)
					)
					(else 
						(super doVerb: theVerb param2 &rest)
					)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance limo of Actor
	(properties
		description {tvoje limuzína}
		approachX 288
		approachY 107
		view 250
		loop 3
		priority 8
		signal $5810
		illegalBits $0000
	)
	
	(method (init)
		(self approachVerbs: 3)
		(super init:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(2 (proc0_14 250 5))
			(3
				(proc0_2)
				(theMusic3 number: 191 loop: 1 play:)
				(self cue:)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (cue)
		(super cue:)
		(switch (++ local1)
			(1 (proc0_17 2 2 self))
			(2
				(gLarry hide:)
				(proc0_17 30 1 self)
			)
			(3
				(theMusic3 number: 192 loop: 1 play:)
				(self cue:)
			)
			(4 (proc0_17 20 1 self))
			(5 (global2 newRoom: 200))
		)
	)
)

(instance tower of Feature
	(properties
		y 1
		nsTop 20
		nsLeft 256
		nsBottom 68
		nsRight 295
		description {kontrolní vìž}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 250 6))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance bush of Feature
	(properties
		y 1
		nsTop 130
		nsLeft 242
		nsBottom 171
		nsRight 319
		description {køoví}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 250 7))
			(3 (proc0_14 250 8))
			(5 (proc0_14 250 9))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance luggage of Feature
	(properties
		y 1
		nsTop 101
		nsLeft 118
		nsBottom 124
		nsRight 149
		description {zavazadla}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 250 10))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance luggage2 of Feature
	(properties
		y 1
		nsTop 135
		nsLeft 55
		nsBottom 150
		nsRight 82
		description {zavazadla}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 250 10))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance car of Feature
	(properties
		y 1
		nsTop 124
		nsLeft 95
		nsBottom 161
		nsRight 160
		description {auto}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 250 11))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance car2 of Feature
	(properties
		y 1
		nsTop 161
		nsLeft 61
		nsBottom 188
		nsRight 147
		description {auto}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 250 12))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance driveway of Feature
	(properties
		y 1
		nsTop 105
		nsLeft 150
		nsBottom 129
		nsRight 319
		description {pøíjezdová cesta}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 250 13))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance otherDoor of Feature
	(properties
		y 1
		nsTop 67
		nsLeft 46
		nsBottom 131
		nsRight 99
		description {dveøe}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 250 14))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance theSign of View
	(properties
		x 224
		y 67
		description {znaèka}
		view 250
	)
	
	(method (doVerb theVerb &tmp [temp0 40])
		(switch theVerb
			(2
				(Format
					@temp0
					250
					15
					(switch global160
						(0 {Los Angeles})
						(1 {New York})
						(2 {Atlantic City})
						(3 {Miami})
					)
				)
				(proc0_14 @temp0)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance envelope of Prop
	(properties
		x 206
		y 99
		description {èistá hnìdá obálka}
		approachX 205
		approachY 93
		view 250
		loop 2
		priority 6
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(2 (proc0_14 250 17))
			(3
				(if (not (gLarry has: 21))
					(proc0_2)
					(= local0 0)
					(gLarry get: 21)
					(proc0_3)
					(proc0_10 12)
					(proc0_14 250 18)
					(proc0_17 3 1 self)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (cue)
		(proc0_14 250 16)
		(self dispose:)
	)
)

(instance plane of Actor
	(properties
		description {letadlo}
		view 250
		priority 3
		signal $6810
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(2 (proc0_14 250 19))
			(3 (proc0_14 250 20))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance trashCan of Feature
	(properties
		x 201
		y 94
		nsTop 88
		nsLeft 196
		nsBottom 101
		nsRight 206
		description {koš na odpadky}
		sightAngle 90
		approachX 205
		approachY 93
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(if local0 (proc0_14 250 21) else (proc0_14 250 22))
			)
			(3
				(if local0 (envelope doVerb: 3) else (proc0_14 250 23))
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance cloud of View
	(properties
		description {mrak}
		view 250
		priority 1
		signal $7810
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(2 (proc0_14 250 24))
			(3 (proc0_14 250 25))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance door of Door
	(properties
		x 260
		y 101
		description {dveøe}
		sightAngle 90
		approachX 261
		approachY 104
		lookStr {Tyto dveøe vedou k exkluzivním branám spoleènosti AeroBlb.}
		view 251
		entranceTo 270
		openSnd 293
		closeSnd 0
		moveToX 261
		moveToY 102
		enterType 0
		exitType 0
	)
)

(instance theMusic3 of Sound
	(properties)
)

(instance sPlane of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0 (= seconds (Random 6 11)))
			(1
				(gLongSong2 number: 254 loop: 1 flags: 1 play: 127)
				(switch (Random 1 4)
					(1
						(plane
							show:
							setCel: 4
							posn: 347 31
							setMotion: MoveTo 120 55 self
						)
					)
					(2
						(plane
							show:
							setCel: 7
							posn: 319 18
							setMotion: MoveTo 108 57 self
						)
					)
					(3
						(plane
							show:
							setCel: 5
							posn: 319 25
							setMotion: MoveTo 124 66 self
						)
					)
					(4
						(plane
							show:
							setCel: 6
							posn: 283 -3
							setMotion: MoveTo 73 48 self
						)
					)
				)
			)
			(2 (plane hide:) (= ticks 30))
			(3
				(gLongSong2 fade: 0 10 10 1)
				(self init:)
			)
		)
	)
)

(instance sLimo of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gLarry hide: posn: 287 110)
				(= cycles 2)
			)
			(1
				(if (proc0_6 38)
					(self changeState: 20)
				else
					(theMusic3 number: 255 loop: 1 play: self hold: 10)
					(limo setMotion: MoveTo 340 115 self)
				)
			)
			(2
				(limo xStep: 2 setMotion: MoveTo 295 115 self)
			)
			(3
				(limo xStep: 1 setMotion: MoveTo 277 115 self)
			)
			(4
				(theMusic3 release:)
				(limo stopUpd:)
				(= state 19)
			)
			(20
				(theMusic3 number: 191 loop: 1 play:)
				(= ticks 100)
			)
			(21 (= ticks 10))
			(22
				(gLarry
					show:
					setLoop: 3
					moveSpeed: 15
					setMotion: MoveTo 287 105 self
				)
			)
			(23
				(theMusic3 number: 192 loop: 1 play:)
				(gLarry normalize: 553 setStep: 2 1)
				(proc0_7 38)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)
