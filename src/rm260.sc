;;; Sierra Script 1.0 - (do not remove this comment)
(script# 260)
(include sci.sh)
(use Main)
(use LLRoom)
(use Polygon)
(use CueObj)
(use n958)
(use Sound)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm260 0
)

(local
	local0
	local1
)
(instance rm260 of LLRoom
	(properties
		lookStr {You are in the west wing of the lavish AeroDork Airline terminal building.}
		picture 260
		east 270
	)
	
	(method (init)
		(gLarry init: illegalBits: -32768 normalize:)
		(switch gGNumber
			(east (= style 11))
			(else 
				(gLarry posn: 292 134 setHeading: 270 edgeHit: 0)
			)
		)
		(super init:)
		(proc958_0 128 161 162 263 264 560 265)
		(switch global160
			(0
				(ad1 loop: 0 cel: 0 init:)
				(ad2 loop: 0 cel: 1 init:)
				(ad3 loop: 0 cel: 2 init:)
				(ad4 loop: 0 cel: 3 init:)
			)
			(1
				(ad1 loop: 1 cel: 0 init:)
				(ad2 loop: 1 cel: 1 init:)
				(ad3 loop: 1 cel: 2 init:)
				(ad4 loop: 1 cel: 3 init:)
			)
			(2
				(slots init:)
				(slot1 init: approachVerbs: 3)
				(slot2 init: approachVerbs: 3)
				(slot3 init: approachVerbs: 3)
				(slot4 init: approachVerbs: 3)
				(handle1
					init:
					approachVerbs: 3
					approachX: (slot1 approachX?)
					approachY: (slot1 approachY?)
				)
				(handle2
					init:
					approachVerbs: 3
					approachX: (slot2 approachX?)
					approachY: (slot2 approachY?)
				)
				(handle3
					init:
					approachVerbs: 3
					approachX: (slot3 approachX?)
					approachY: (slot3 approachY?)
				)
				(handle4
					init:
					approachVerbs: 3
					approachX: (slot4 approachX?)
					approachY: (slot4 approachY?)
				)
				(ad1 loop: 2 cel: 0 init:)
				(ad2 loop: 2 cel: 1 init:)
				(ad3 loop: 2 cel: 2 init:)
				(ad4 loop: 2 cel: 3 init:)
			)
			(3
				(cigaretteMachine init: approachVerbs: 3)
				(ad1 loop: 3 cel: 0 init:)
				(ad2 loop: 3 cel: 1 init:)
				(ad3 loop: 3 cel: 2 init:)
				(ad4 loop: 3 cel: 3 init:)
			)
		)
		(gAddToPics doit:)
		(switch global160
			(3
				(self
					addObstacle:
						((Polygon new:)
							type: 2
							init:
								0
								0
								319
								0
								319
								112
								306
								112
								303
								119
								280
								122
								267
								120
								259
								113
								55
								114
								50
								119
								97
								119
								103
								126
								98
								131
								66
								131
								51
								149
								19
								149
								5
								164
								5
								187
								319
								187
								319
								189
								0
								189
							yourself:
						)
				)
			)
			(2
				(self
					addObstacle:
						((Polygon new:)
							type: 2
							init:
								0
								0
								319
								0
								319
								112
								306
								112
								303
								119
								280
								122
								267
								120
								253
								113
								223
								113
								223
								120
								100
								123
								94
								121
								85
								119
								82
								114
								53
								113
								4
								162
								7
								187
								319
								187
								319
								189
								0
								189
							yourself:
						)
						((Polygon new:)
							type: 2
							init: 73 119 81 119 97 123 101 130 54 130 50 125 52 119
							yourself:
						)
				)
			)
			(else 
				(self
					addObstacle:
						((Polygon new:)
							type: 2
							init:
								0
								0
								319
								0
								319
								112
								306
								112
								303
								119
								280
								122
								267
								120
								259
								113
								54
								113
								4
								164
								4
								187
								319
								187
								319
								189
								0
								189
							yourself:
						)
						((Polygon new:)
							type: 2
							init: 95 120 105 122 105 126 89 130 63 130 50 126 51 122 62 120
							yourself:
						)
				)
			)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init: 108 180 128 154 279 154 301 181
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 107 157 113 160 114 165 107 171 93 171 80 170 75 162 85 157
					yourself:
				)
		)
		(ashtray init:)
		(chairs init:)
		(post init:)
		(plant init:)
		(plantSouth init:)
		(door init:)
		(outlet init: approachVerbs: 4 3)
		(proc0_3)
		(proc0_17 (Random 40 120) 0 self)
	)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(gLarry mover?)
				(== (gLarry view?) 550)
				(< (gLarry loop?) 8)
			)
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
	)
	
	(method (doVerb theVerb &tmp [temp0 100])
		(switch theVerb
			(2
				(Format
					@temp0
					260
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
			flags: 1
			setLoop: 1
			play:
		)
		(proc0_17 (Random 20 40) 2 self)
	)
	
	(method (newRoom newRoomNumber)
		(gLl5Timer dispose: delete:)
		(super newRoom: newRoomNumber)
	)
)

(instance cigaretteMachine of PicView
	(properties
		x 39
		y 142
		description {the cigarette machine}
		approachX 64
		approachY 142
		view 265
		priority 9
		signal $4010
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 260 1))
			(3
				(proc0_2)
				(global2 setScript: sGetChange)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance chairs of Feature
	(properties
		x 203
		y 152
		nsTop 131
		nsLeft 117
		nsBottom 173
		nsRight 289
		description {the chairs}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 260 2))
			(3 (proc0_14 260 3))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance post of Feature
	(properties
		x 75
		y 63
		nsLeft 59
		nsBottom 126
		nsRight 91
		description {the column}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 260 4))
			(3 (proc0_14 260 5))
			(5 (proc0_18 gLarry 260 6))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance plant of Feature
	(properties
		x 285
		y 90
		nsTop 70
		nsLeft 259
		nsBottom 111
		nsRight 312
		description {the plant}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 260 7))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance door of Feature
	(properties
		x 227
		y 75
		nsTop 43
		nsLeft 205
		nsBottom 108
		nsRight 249
		description {the door}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 260 8))
			(3 (proc0_14 260 9))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance sGetChange of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(Load rsVIEW 161)
				(gLarry setHeading: 270 self)
			)
			(1 (= ticks 20))
			(2
				(gLarry
					view: 161
					setLoop: 0
					setCel: 0
					cycleSpeed: 8
					setCycle: CT 2 1 self
				)
			)
			(3 (= ticks 30))
			(4 (gLarry setCycle: Beg self))
			(5
				(proc0_14 260 10)
				(if
					(and
						(not (proc0_6 34))
						(not (proc0_6 11))
						(not (gLarry has: 10))
					)
					(gLarry get: 10)
					(proc0_10 5 34)
					(proc0_14 260 11)
					(= global168 2)
				else
					(proc0_14 260 12)
				)
				(gLarry setLoop: 1 normalize:)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance outlet of Feature
	(properties
		x 5
		y 161
		z 30
		nsTop 118
		nsBottom 143
		nsRight 16
		description {the outlet}
		sightAngle 40
		approachX 32
		approachY 145
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(global2 setScript: (ScriptID 22 2) 0 1)
			)
			(4
				(if (== param2 1)
					(global2 setScript: (ScriptID 22 0))
				else
					(proc0_14 260 13)
				)
			)
			(2
				(if local0 (proc0_14 260 14) else (proc0_14 260 15))
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance plantSouth of Feature
	(properties
		x 34
		y 173
		nsTop 158
		nsBottom 189
		nsRight 69
		description {the plant}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 260 7))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance camera of View
	(properties
		x 27
		y 146
		view 161
		loop 4
		signal $4000
	)
)

(instance ad1 of PicView
	(properties
		x 11
		y 22
		description {the sign}
		view 263
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(switch global160
					(0 (proc0_14 260 16))
					(1 (proc0_14 260 17))
					(2 (proc0_14 260 18))
					(3 (proc0_14 260 19))
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
		x 146
		y 9
		description {the sign}
		view 263
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(switch global160
					(0 (proc0_14 260 20))
					(1 (proc0_14 260 21))
					(2 (proc0_14 260 22))
					(3 (proc0_14 260 23))
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
		x 235
		y 10
		description {the sign}
		view 263
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(switch global160
					(0 (proc0_14 260 24))
					(1
						(proc0_10 1 91)
						(proc0_14 260 25)
					)
					(2 (proc0_14 260 26))
					(3 (proc0_14 260 27))
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
		x 311
		y 13
		description {the sign}
		view 263
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(switch global160
					(0 (proc0_14 260 28))
					(1 (proc0_14 260 29))
					(2 (proc0_14 260 30))
					(3 (proc0_14 260 31))
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance ashtray of Feature
	(properties
		x 94
		y 149
		nsTop 133
		nsLeft 85
		nsBottom 165
		nsRight 104
		description {the ashtray}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2 &tmp [temp0 30])
		(switch theVerb
			(2 (proc0_14 260 32))
			(3 (proc0_14 260 33))
			(else 
				(super doVerb: theVerb param2 &rest)
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

(instance handle1 of PicView
	(properties
		x 122
		y 100
		z 14
		description {the slot machine}
		view 264
		loop 1
		priority 0
		signal $0010
	)
	
	(method (doVerb)
		(= local1 1)
		(slot1 doVerb: &rest)
	)
)

(instance handle2 of Prop
	(properties
		x 151
		y 86
		description {the slot machine}
		view 264
		loop 1
		priority 11
		signal $4000
	)
	
	(method (doVerb)
		(= local1 2)
		(slot1 doVerb: &rest)
	)
)

(instance handle3 of PicView
	(properties
		x 180
		y 86
		description {the slot machine}
		view 264
		loop 1
		priority 6
		signal $0010
	)
	
	(method (doVerb)
		(= local1 3)
		(slot1 doVerb: &rest)
	)
)

(instance handle4 of PicView
	(properties
		x 207
		y 85
		description {the slot machine}
		view 264
		loop 1
	)
	
	(method (doVerb)
		(= local1 4)
		(slot1 doVerb: &rest)
	)
)

(instance slots of PicView
	(properties
		x 166
		y 22
		z -100
		description {the slot machine}
		view 264
		priority 4
		signal $4010
	)
	
	(method (onMe)
		(return 0)
	)
)

(instance slot1 of Feature
	(properties
		x 112
		y 99
		nsTop 77
		nsLeft 100
		nsBottom 121
		nsRight 124
		description {the slot machine}
		sightAngle 40
		approachX 117
		approachY 120
	)
	
	(method (doVerb theVerb param2)
		(if (not local1) (= local1 1))
		(switch theVerb
			(2 (proc0_14 260 34))
			(3 (global2 setScript: sSlots))
			(4
				(if (== param2 10)
					(proc0_14 260 35)
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

(instance slot2 of Feature
	(properties
		x 142
		y 98
		nsTop 77
		nsLeft 128
		nsBottom 120
		nsRight 156
		description {the slot machine}
		sightAngle 40
		approachX 146
		approachY 122
	)
	
	(method (doVerb)
		(= local1 2)
		(slot1 doVerb: &rest)
	)
)

(instance slot3 of Feature
	(properties
		x 172
		y 99
		nsTop 77
		nsLeft 160
		nsBottom 121
		nsRight 184
		description {the slot machine}
		sightAngle 40
		approachX 176
		approachY 122
	)
	
	(method (doVerb)
		(= local1 3)
		(slot1 doVerb: &rest)
	)
)

(instance slot4 of Feature
	(properties
		x 199
		y 98
		nsTop 76
		nsLeft 187
		nsBottom 121
		nsRight 211
		description {the slot machine}
		sightAngle 40
		approachX 201
		approachY 122
	)
	
	(method (doVerb)
		(= local1 4)
		(slot1 doVerb: &rest)
	)
)

(instance sSlots of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(= register 0)
				(gLarry setLoop: 3)
				(= cycles 2)
			)
			(1
				(gLarry
					view: 261
					setLoop: 0
					cycleSpeed: 12
					setCel: 0
					setCycle: CT 3 1 self
				)
			)
			(2
				(if (and (not (proc0_6 36)) (== local1 2))
					(handle2 setCel: 255 cycleSpeed: 8 hide:)
					(gLarry setCycle: End self)
				else
					(= ticks 90)
				)
			)
			(3
				(if (and (not (proc0_6 36)) (== local1 2))
					(handle2 show: setCycle: Beg)
					(gLongSong2 number: 262 loop: 1 play: self)
				else
					(gLarry setCycle: Beg self)
				)
			)
			(4
				(cond 
					((or (!= local1 2) (proc0_6 36)) (proc0_14 260 36 67 -1 185 108 self))
					((not (proc0_6 36)) (gLongSong number: 263 loop: 1 play: self) (= register 1))
					(else (= ticks 10))
				)
			)
			(5 (= ticks 30))
			(6
				(gLongSong stop:)
				(if (and register (not (proc0_6 36)))
					(proc0_10 5 36)
					(proc0_14 260 37)
					(gLarry get: 10)
					(= global168 1)
				)
				(proc0_3)
				(gLarry setLoop: 3 normalize:)
				(= local1 0)
				(self dispose:)
			)
		)
	)
)
