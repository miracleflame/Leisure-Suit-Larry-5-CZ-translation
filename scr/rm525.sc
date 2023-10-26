;;; Sierra Script 1.0 - (do not remove this comment)
(script# 525)
(include sci.sh)
(use Main)
(use LLRoom)
(use Door)
(use PolyPath)
(use Polygon)
(use CueObj)
(use n958)
(use Sound)
(use Cycle)
(use InvI)
(use User)
(use PicView)
(use Obj)

(public
	rm525 0
)

(local
	local0
	local1
)
(instance rm525 of LLRoom
	(properties
		picture 525
		east 530
		south 510
	)
	
	(method (init)
		(proc958_0 128 525 527 510 526)
		(Load rsSOUND 526)
		(gLarry normalize:)
		(daDoor init: approachVerbs: 3)
		(door init:)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						0
						319
						0
						319
						189
						235
						189
						252
						166
						229
						155
						193
						166
						166
						155
						122
						170
						114
						164
						96
						177
						64
						189
						0
						189
					yourself:
				)
		)
		(switch gGNumber
			(520
				(gLarry posn: 210 161 init:)
				(if (> ((Inv at: 14) state?) 1)
					(proc0_2)
					(global2 setScript: sToHollerith)
				else
					(proc0_3)
				)
			)
			(east
				(proc0_3)
				(gLarry posn: 238 162 setHeading: 270 edgeHit: 0)
			)
			(else 
				(= global160 1)
				(gLarry posn: 146 237 setHeading: 45 get: 14 init:)
				(global2 setScript: sEnter)
			)
		)
		(super init:)
		(fatLady init: setScript: sFatLadyEating)
		(tapeReader init: approachVerbs: 3 4)
		(cactus init:)
		(tables init:)
		(SprattFamilyTable init:)
		(larryTable init: approachVerbs: 3)
		(baldMan init:)
		(man1 init:)
		(man2 init:)
		(man3 init:)
		(woman1 init:)
		(gAddToPics doit:)
	)
	
	(method (doit)
		(super doit: &rest)
		(cond 
			(script)
			(
				(and
					(== (gLarry view?) 526)
					(gLarry mover?)
					(User canControl:)
					(User canInput:)
				)
				(= local0 ((User curEvent?) x?))
				(= local1 ((User curEvent?) y?))
				(proc0_2)
				(global2 setScript: sStandUp)
			)
			((proc0_5 gLarry 4) (proc0_2) (self setScript: sExitSouth))
		)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(if (!= (gLarry view?) 526)
					(proc0_14 525 0)
				else
					(proc0_14 525 1)
				)
			)
			(else 
				(super doVerb: theVerb param2)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(if (== newRoomNumber 530) (gLongSong fade:))
	)
)

(instance sToHollerith of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= ticks 123))
			(1
				(gLarry
					setMotion: PolyPath (door approachX?) (door approachY?) self
				)
			)
			(2
				((global2 obstacles?) dispose:)
				(= cycles 2)
			)
			(3
				(global2
					addObstacle:
						((Polygon new:)
							type: 2
							init: 117 167 117 179 98 179 98 167
							yourself:
						)
				)
				(door locked: 0 doVerb: 3)
				(self dispose:)
			)
		)
	)
)

(instance sEnter of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry setMotion: MoveTo 196 185 self)
			)
			(1 (proc0_3) (self dispose:))
		)
	)
)

(instance sMichelle of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(michelle setCycle: Fwd setMotion: MoveTo 190 191 self)
			)
			(1
				(proc0_10 3)
				(proc0_14 525 2)
				(michelle setMotion: MoveTo 216 163 self)
			)
			(2
				(michelle
					setLoop: 1
					posn: 207 162
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(screen init: setCycle: Fwd)
				(= seconds (Random 3 6))
			)
			(4
				(michelle
					setCycle: Beg self
					illegalBits: 0
					ignoreActors: 1
				)
			)
			(5
				(screen dispose:)
				(michelle
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 242 164 self
				)
			)
			(6 (door setCycle: End self))
			(7
				(michelle setMotion: MoveTo 308 144 self)
			)
			(8 (door setCycle: Beg self))
			(9
				(door stopUpd:)
				(michelle dispose:)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance sFatLadyEating of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(fatLady setCel: 0)
				(if (not (Random 0 2))
					(= seconds (Random 2 6))
				else
					(= cycles 1)
				)
			)
			(1 (fatLady setCycle: End self))
			(2
				(slobSound play:)
				(self init:)
			)
		)
	)
)

(instance sSitDown of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gLarry view: 526 setLoop: 0 setCycle: End self)
			)
			(1
				(if (proc0_6 2)
					(proc0_3)
				else
					(proc0_7 2)
					(User canInput: 1)
					(gIconBar enable: 1 3)
					(gIconBar curIcon: (gIconBar at: 1))
					(gGame setCursor: ((gIconBar curIcon?) cursor?))
					(michelle init: setScript: sMichelle)
				)
				(self dispose:)
			)
		)
	)
)

(instance sStandUp of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (gLarry setCycle: Beg self))
			(1
				(proc0_3)
				(gLarry normalize:)
				(if (!= (CueObj client?) larryTable)
					(if
						(and
							((CueObj client?) approachX?)
							(!= ((gIconBar curIcon?) cursor?) 0)
						)
						(gLarry
							setMotion:
								PolyPath
								((CueObj client?) approachX?)
								(+ (gLarry z?) ((CueObj client?) approachY?))
								CueObj
						)
					else
						(gLarry setMotion: PolyPath local0 local1)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance sExitSouth of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gLarry
					setMotion: MoveTo (- (gLarry x?) 80) (+ (gLarry y?) 50) self
				)
			)
			(1 (global2 newRoom: 510))
		)
	)
)

(instance door of Door
	(properties
		x 264
		y 165
		description {the door}
		sightAngle 90
		approachX 231
		approachY 164
		view 525
		priority 3
		signal $4010
		entranceTo 530
		locked 1
		openSnd 0
		closeSnd 0
		moveToX 292
		moveToY 154
		exitType 0
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(if (proc0_6 2) (proc0_14 525 3) else (proc0_14 525 4))
			)
			(3
				(if locked (proc0_14 525 5) else (super doVerb: 3))
			)
			(5 (proc0_18 gLarry 525 6))
			(4
				(switch param2
					(14 (proc0_14 525 7))
					(7 (proc0_14 525 8))
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

(instance michelle of Actor
	(properties
		x 128
		y 247
		description {Michelle Milken}
		lookStr {It's her, Larry! Watch her carefully; perhaps you could follow her!}
		view 527
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(5 (proc0_18 gLarry 525 9))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance fatLady of Prop
	(properties
		x 39
		y 146
		description {the fat lady}
		sightAngle 40
		lookStr {You presume she's the one who sings when it's over.}
		view 525
		loop 7
		priority 1
		signal $4810
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 525 10))
			(5
				(proc0_18 gLarry 525 11)
				(proc0_14 525 12)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance screen of Prop
	(properties
		x 192
		y 132
		description {the monitor}
		sightAngle 40
		view 510
		loop 2
		priority 15
		signal $4810
	)
)

(instance man1 of PicView
	(properties
		x 159
		y 70
		description {the bald man}
		sightAngle 90
		lookStr {That's one of the few people in this huge cafe.}
		view 525
		loop 5
		priority 4
		signal $6810
	)
)

(instance man2 of PicView
	(properties
		x 73
		y 70
		description {the lonely man}
		sightAngle 90
		lookStr {That's one of the few people in this huge cafe.}
		view 525
		loop 5
		cel 1
		priority 4
		signal $6810
	)
)

(instance man3 of PicView
	(properties
		x 116
		y 86
		description {the lonely man}
		sightAngle 90
		lookStr {That's one of the few people in this huge cafe.}
		view 525
		loop 6
		priority 4
		signal $6810
	)
)

(instance woman1 of PicView
	(properties
		x 21
		y 92
		description {the lonely woman}
		sightAngle 90
		lookStr {That's one of the few people in this huge cafe.}
		view 525
		loop 6
		cel 1
		priority 5
		signal $6810
	)
)

(instance baldMan of PicView
	(properties
		x 62
		y 161
		description {Jack}
		sightAngle 90
		view 525
		loop 2
		priority 4
		signal $6810
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 525 13))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance SprattFamilyTable of Feature
	(properties
		x 52
		y 160
		nsTop 143
		nsLeft 14
		nsBottom 177
		nsRight 90
		description {their table}
		sightAngle 40
		lookStr {This table seems to be occupied. Extremely occupied!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 525 14))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance larryTable of Feature
	(properties
		x 133
		y 148
		nsTop 124
		nsLeft 90
		nsBottom 162
		nsRight 170
		description {your table}
		sightAngle 40
		approachX 114
		approachY 163
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(switch ((Inv at: 14) state?)
					(1 (proc0_14 525 15))
					(else 
						(proc0_14 525 16)
						(proc0_14 525 17 67 -1 185)
					)
				)
			)
			(3
				(if (and (User canInput:) (User canControl:))
					(proc0_2)
					(global2 setScript: sSitDown)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance tables of Feature
	(properties
		x 102
		y 57
		nsBottom 115
		nsRight 204
		description {the tables}
		sightAngle 40
		lookStr {What a huge cafe to have so few customers.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 525 18))
			(5 (proc0_14 525 19))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance cactus of Feature
	(properties
		x 294
		y 162
		nsTop 137
		nsLeft 271
		nsBottom 188
		nsRight 318
		description {the cactus}
		sightAngle 40
		lookStr {Insert your favorite cactus and "prick" joke here.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_18 gLarry 525 20))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance tapeReader of Feature
	(properties
		x 195
		y 142
		nsTop 120
		nsLeft 176
		nsBottom 158
		nsRight 215
		description {the tape reader}
		sightAngle 40
		approachX 210
		approachY 161
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 525 21))
			(3
				(if (and (User canInput:) (User canControl:))
					(proc0_2)
					(global2 newRoom: 520)
				)
			)
			(4
				(switch param2
					(14 (self doVerb: 3))
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

(instance daDoor of Feature
	(properties
		x 246
		y 125
		nsTop 92
		nsLeft 227
		nsBottom 159
		nsRight 266
		description {the door}
		sightAngle 40
		onMeCheck $0002
		approachX 231
		approachY 164
	)
	
	(method (doVerb theVerb param2)
		(door doVerb: theVerb param2)
	)
)

(instance slobSound of Sound
	(properties
		flags $0001
		number 526
	)
)
