;;; Sierra Script 1.0 - (do not remove this comment)
(script# 270)
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
	rm270 0
)

(local
	local0
	local1
	local2
	redHeadX
	blondeX
	local5
	local6
	[local7 500]
)
(instance rm270 of LLRoom
	(properties
		lookStr {Jsi v èekárnì letecké spoleènosti AeroBlb a u bývalé pokladny. Ze vzdálené stìny na tebe shlíží bezpeènostní kamera.}
		picture 270
		north 290
		east 280
		south 250
		west 260
	)
	
	(method (init)
		(gLarry init: normalize:)
		(blonde
			x: (Random 178 235)
			y: 82
			ignoreActors: 1
			setLoop: gBlondeLoop
			init:
		)
		(redHead
			x: (Random 260 305)
			y: 82
			ignoreActors: 1
			setLoop: gRedHeadLoop
			init:
		)
		(= blondeX (blonde x?))
		(= redHeadX (redHead x?))
		(if (!= gGNumber (global2 east?))
			(blonde setLoop: 3)
			(redHead setLoop: 4)
		)
		(door init: setPri: 4)
		(camera init:)
		(switch gGNumber
			(south
				(camera setCel: 5)
				(if (proc0_6 8) (proc0_8 38))
			)
			(north (gLarry edgeHit: 0))
			(east
				(blonde init: posn: (+ gBlondeX 319) 82)
				(redHead init: posn: (+ gRedHeadX 319) 82)
				(proc0_3)
				(camera setCel: 255)
				(= style 11)
			)
			(west (proc0_3) (= style 12))
			(else 
				(proc0_3)
				(gLarry posn: 253 185 edgeHit: 0 setHeading: 360)
				(camera setCel: 5)
			)
		)
		(super init:)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init: 0 0 319 0 319 113 96 113 84 102 76 102 68 113 0 113
					yourself:
				)
				((Polygon new:)
					type: 2
					init:
						64
						174
						27
						170
						16
						157
						7
						157
						10
						154
						17
						154
						35
						141
						87
						141
						234
						141
						241
						151
						258
						151
						268
						155
						269
						162
						253
						168
						250
						174
					yourself:
				)
		)
		(plant init:)
		(chairs init:)
		(ashtray init:)
		(vipSign init:)
		(theCounter init:)
		(if (== global160 1)
			(cannister init: approachVerbs: 2 3)
		)
		(switch global160
			(0
				(blonde description: {Buffi})
				(redHead description: {Muffi})
				(ad1 loop: 4 cel: 0 init:)
				(ad2 loop: 4 cel: 1 init:)
				(ad3 loop: 4 cel: 2 init:)
				(ad4 loop: 4 cel: 3 init:)
			)
			(1
				(blonde description: {Tracie})
				(redHead description: {Stacie})
				(ad1 loop: 5 cel: 0 init:)
				(ad2 loop: 5 cel: 1 init:)
				(ad3 loop: 5 cel: 2 init:)
				(ad4 loop: 5 cel: 3 init:)
			)
			(2
				(blonde description: {Cherri})
				(redHead description: {Barri})
				(ad1 loop: 6 cel: 0 init:)
				(ad2 loop: 6 cel: 1 init:)
				(ad3 loop: 6 cel: 2 init:)
				(ad4 loop: 6 cel: 3 init:)
			)
			(3
				(blonde description: {Dixie})
				(redHead description: {Trixie})
				(ad1 loop: 7 cel: 0 init:)
				(ad2 loop: 7 cel: 1 init:)
				(ad3 loop: 7 cel: 2 init:)
				(ad4 loop: 7 cel: 3 init:)
			)
		)
		(gAddToPics doit:)
		(blonde setScript: sBlonde)
		(redHead setScript: sRedHead)
		(DoSound 19 10)
		(proc0_17 (Random 40 150) 0 self)
	)
	
	(method (doit)
		(super doit:)
		(if (gLarry mover?)
			(switch (gLarry cel?)
				(1
					(if (!= (stepSound number?) 260)
						(stepSound number: 260 play:)
					)
				)
				(4
					(if (!= (stepSound number?) 261)
						(stepSound number: 261 play:)
					)
				)
			)
		)
		(cond 
			(script)
			((== (gLarry edgeHit?) 2)
				(redHead setScript: 0)
				(blonde setScript: 0)
				(= gRedHeadX (redHead x?))
				(= gRedHeadLoop (redHead loop?))
				(= gBlondeX (blonde x?))
				(= gBlondeLoop (blonde loop?))
			)
			((gLarry inRect: 167 105 325 124)
				(if (not local2)
					(= local2 1)
					(blonde setScript: sBlonde 0 365)
				)
				(if (not local1)
					(= local1 1)
					(redHead setScript: sRedHead 0 375)
				)
			)
		)
	)
	
	(method (doVerb theVerb &tmp [temp0 150])
		(switch theVerb
			(2
				(Format
					@temp0
					270
					0
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
	
	(method (cue)
		(announcement
			number: (Random 273 275)
			setLoop: 1
			flags: 1
			play:
		)
		(proc0_17 (Random 20 40) 2 self)
	)
	
	(method (newRoom newRoomNumber)
		(if (not (proc999_5 newRoomNumber 260 280))
			(DoSound 19 0)
		)
		(gLl5Timer dispose: delete:)
		(super newRoom: newRoomNumber)
	)
)

(instance cannister of PicView
	(properties
		x 142
		y 111
		description {charitativní kontejner}
		sightAngle 90
		approachX 139
		approachY 114
		view 273
		priority 4
		signal $6810
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(if
				(and (not (gLarry has: 10)) (not (proc0_6 13)))
					(Load rsVIEW 291)
					(global2 setScript: sStealChange)
				else
					(proc0_14 270 1)
					(proc0_14 270 2 67 -1 185)
				)
			)
			(2
				(if
				(and (not (gLarry has: 10)) (not (proc0_6 13)))
					(proc0_14 270 3)
				else
					(proc0_14 270 4)
				)
			)
			(4
				(if (== param2 10)
					(++ local6)
					(proc0_14 270 5)
					(if (and (> local6 3) (not (Random 0 10)))
						(proc0_14 270 6 67 -1 185)
						(= local6 0)
					)
				else
					(super doVerb: theVerb param2 &rest)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance plant of Feature
	(properties
		x 46
		y 140
		nsTop 117
		nsLeft 28
		nsBottom 164
		nsRight 64
		description {rostlina}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 270 7))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance chairs of Feature
	(properties
		x 156
		y 146
		nsTop 126
		nsLeft 72
		nsBottom 167
		nsRight 240
		description {židle}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 270 8))
			(3 (proc0_14 270 9))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance ashtray of Feature
	(properties
		x 249
		y 148
		nsTop 134
		nsLeft 240
		nsBottom 162
		nsRight 258
		description {popelník}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2 &tmp [temp0 30])
		(switch theVerb
			(2 (proc0_14 270 10))
			(3
				(if (Random 0 1)
					(proc0_14 270 11)
				else
					(proc0_14 270 12)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance vipSign of Feature
	(properties
		x 82
		y 31
		nsTop 19
		nsLeft 51
		nsBottom 44
		nsRight 114
		description {cedule}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 270 13))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance theCounter of Feature
	(properties
		y 1
		nsTop 44
		nsLeft 162
		nsBottom 88
		nsRight 317
		description {pultík na prodej vstupenek}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_14 270 14)
				(proc0_14 270 15 67 -1 185)
			)
			(3
				(Format
					@local7
					270
					16
					(blonde description?)
					(redHead description?)
				)
				(proc0_14 @local7)
				(proc0_14 270 17 67 -1 185)
			)
			(5 (proc0_14 270 18))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance blonde of Actor
	(properties
		sightAngle 40
		view 277
		illegalBits $0000
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(Format @local7 270 19 (blonde description?))
				(proc0_14 @local7)
			)
			(3
				(Format @local7 270 20 (blonde description?))
				(proc0_14 @local7)
			)
			(5
				(proc0_14 270 21)
				(proc0_14 270 22)
			)
			(4
				(Format @local7 270 23 (blonde description?))
				(proc0_14 @local7)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance redHead of Actor
	(properties
		sightAngle 90
		view 276
		illegalBits $0000
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(Format @local7 270 24 (redHead description?))
				(proc0_14 @local7)
				(proc0_14 270 25)
			)
			(3
				(proc0_14 270 26)
				(proc0_14 270 27)
			)
			(5
				(proc0_14 270 21)
				(proc0_14 270 28)
			)
			(4
				(Format @local7 270 23 (redHead description?))
				(proc0_14 @local7)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance sStealChange of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 291
					ignoreActors: 1
					illegalBits: 0
					setLoop: 3
					cycleSpeed: 6
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(proc0_14 270 29)
				(gLarry get: 10)
				(= global168 1)
				(gLarry normalize:)
				(proc0_10 5 13)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance sBlonde of Script
	(properties)
	
	(method (changeState newState &tmp blondeX_2)
		(switch (= state newState)
			(0 (= cycles 2))
			(1
				(= blondeX_2 (blonde x?))
				(if register
					(= blondeX register)
				else
					(switch (Random 1 2)
						(1
							(= blondeX (Random 178 307))
						)
						(2
							(= blondeX (Random 332 375))
						)
					)
				)
				(if
					(and
						(not register)
						(or
							(and
								(< blondeX (redHead x?))
								(< (redHead x?) blondeX_2)
							)
							(and
								(< blondeX_2 (redHead x?))
								(< (redHead x?) blondeX)
							)
						)
					)
					(self init:)
				else
					(blonde
						setLoop: -1
						setCycle: Walk
						setMotion: MoveTo blondeX 82 self
					)
				)
			)
			(2
				(if (== (blonde x?) blondeX) (blonde setLoop: 3))
				(= seconds (Random 2 5))
			)
			(3
				(= local2 (= register 0))
				(self init:)
			)
		)
	)
)

(instance sRedHead of Script
	(properties)
	
	(method (changeState newState &tmp redHeadX_2)
		(switch (= state newState)
			(0 (= cycles 2))
			(1
				(= redHeadX_2 (redHead x?))
				(if register
					(= redHeadX register)
				else
					(switch (Random 1 2)
						(1
							(= redHeadX (Random 178 307))
						)
						(2
							(= redHeadX (Random 332 375))
						)
					)
				)
				(if
					(and
						(not register)
						(or
							(and
								(< redHeadX (blonde x?))
								(< (blonde x?) redHeadX_2)
							)
							(and
								(< redHeadX_2 (blonde x?))
								(< (blonde x?) redHeadX)
							)
						)
					)
					(self init:)
				else
					(redHead
						setLoop: -1
						setCycle: Walk
						setMotion: MoveTo redHeadX 82 self
					)
				)
			)
			(2
				(if (== (redHead x?) redHeadX) (redHead setLoop: 4))
				(= seconds (Random 2 5))
			)
			(3
				(= local1 (= register 0))
				(self init:)
			)
		)
	)
)

(instance door of Door
	(properties
		x 98
		y 106
		description {dveøe}
		sightAngle 90
		approachX 81
		approachY 111
		view 270
		entranceTo 290
		locked 1
		moveToX 81
		moveToY 105
		enterType 0
		exitType 0
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 270 30))
			(3 (proc0_14 270 31))
			(5
				(proc0_14 270 32)
				(proc0_14 270 33 67 -1 185)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance ad1 of PicView
	(properties
		x 11
		y 11
		description {cedule}
		sightAngle 90
		view 263
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(switch global160
					(0 (proc0_14 270 34))
					(1 (proc0_14 270 35))
					(2 (proc0_14 270 36))
					(3 (proc0_14 270 37))
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance ad2 of PicView
	(properties
		x 163
		y 11
		description {cedule}
		sightAngle 90
		view 263
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(switch global160
					(0 (proc0_14 270 38))
					(1 (proc0_14 270 39))
					(2
						(proc0_10 1 94)
						(proc0_14 270 40)
					)
					(3 (proc0_14 270 41))
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance ad3 of PicView
	(properties
		x 249
		y 11
		description {cedule}
		sightAngle 90
		view 263
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(switch global160
					(0 (proc0_14 270 42))
					(1 (proc0_14 270 43))
					(2 (proc0_14 270 44))
					(3 (proc0_14 270 45))
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance ad4 of PicView
	(properties
		x 317
		y 8
		description {cedule}
		sightAngle 90
		view 263
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(switch global160
					(0 (proc0_14 270 46))
					(1 (proc0_14 270 47))
					(2 (proc0_14 270 48))
					(3
						(proc0_10 1 93)
						(proc0_14 270 49)
					)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance camera of Prop
	(properties
		x 126
		y 58
		nsTop 46
		nsLeft 112
		nsBottom 63
		nsRight 130
		description {bezpeènostní kamera}
		sightAngle 90
		approachX 92
		approachY 113
		view 270
		loop 1
	)
	
	(method (init)
		(super init:)
		(self approachVerbs: 4 3 2)
	)
	
	(method (doit &tmp temp0 temp1 theCel theLoop [temp4 20])
		(super doit:)
		(if (not (global2 script?))
			(= theCel cel)
			(= theLoop loop)
			(= temp1
				(/ (- (GetAngle x y (gLarry x?) (gLarry y?)) 110) 14)
			)
			(self
				setLoop: (if (> (gLarry y?) 159) 1 else 5)
				setCel: (- 9 temp1)
			)
			(if (or (!= theLoop loop) (!= theCel cel))
				(gLongSong2 number: 271 loop: 1 play:)
			)
		)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 270 50))
			(2 (proc0_14 270 51))
			(4
				(switch param2
					(7
						(global2 setScript: sShowCard)
					)
					(8 (proc0_14 270 52))
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

(instance sShowCard of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(= register 5)
				(proc0_10 9 92)
				(gLarry
					view: 271
					setLoop: 1
					cycleSpeed: 4
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(= start state)
				(= cycles 6)
			)
			(2
				(gLongSong2 number: 272 setLoop: 1 play: self)
			)
			(3
				(if (not (-- register))
					(= cycles 1)
				else
					(if (not (camera cel?))
						(camera setCel: 1 setLoop: 3)
					else
						(camera setCel: 0 setLoop: 3)
					)
					(self init:)
				)
			)
			(4
				(camera setCel: 0)
				(gLarry normalize:)
				(door locked: 0 open:)
				(self dispose:)
			)
		)
	)
)

(instance stepSound of Sound
	(properties)
)

(instance announcement of Sound
	(properties)
)
