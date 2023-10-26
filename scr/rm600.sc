;;; Sierra Script 1.0 - (do not remove this comment)
(script# 600)
(include sci.sh)
(use Main)
(use LLRoom)
(use Door)
(use Class_255_0)
(use Polygon)
(use CueObj)
(use ForwardCounter)
(use n958)
(use Sound)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm600 0
)

(instance rm600 of LLRoom
	(properties
		lookStr {The Shill Building is one of Baltimore's finest office buildings. Its granite, brass and stainless steel facade shines in the sunlight. A revolving door promises access to its interior.}
		north 620
		south 200
	)
	
	(method (init)
		(switch gGNumber
			(north
				(self picture: 610)
				(gLarry
					init:
					normalize: 572
					setStep: 2 1
					posn: 156 177
					setHeading: 180
					edgeHit: 0
				)
				(flagOne init: cycleSpeed: 18 setCycle: Fwd)
				(flagTwo init: cycleSpeed: 24 setCycle: Fwd)
				(revolvingDoor init: cycleSpeed: 10)
				(limo init: approachVerbs: 3)
				(hydrant init:)
				(car init:)
				(shillSign init:)
				(fReflection init:)
				(gLongSong2
					number: 251
					setLoop: -1
					setVol: 127
					flags: 1
					play:
				)
				(proc0_3)
			)
			(south
				(self picture: 610)
				(flagOne init: cycleSpeed: 18 setCycle: Fwd)
				(flagTwo init: cycleSpeed: 24 setCycle: Fwd)
				(revolvingDoor init: cycleSpeed: 10)
				(limo init: approachVerbs: 3)
				(hydrant init:)
				(car init:)
				(shillSign init:)
				(fReflection init:)
				(self setScript: sExitLimo)
			)
			(else 
				(self picture: 600 style: 9)
				(gLarry
					init:
					normalize: 600
					setCel: 0
					posn: 189 126
					cycleSpeed: 12
				)
				(proc958_0 129 610)
				(proc958_0 128 610)
				(proc958_0 132 601)
				(gLongSong number: 600 flags: 1 setLoop: -1 play:)
				(self setScript: sCouple)
			)
		)
		(proc958_0 132 611)
		(super init:)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						189
						0
						0
						156
						0
						156
						180
						52
						180
						52
						182
						264
						182
						264
						180
						174
						180
						174
						137
						174
						0
						319
						0
						319
						189
					yourself:
				)
		)
	)
	
	(method (dispose)
		(gLongSong fade: 0 15 12 1)
		(gLongSong2 fade: 0 15 12 1)
		(super dispose: &rest)
	)
)

(instance sCouple of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry setCycle: ForwardCounter 2 self)
			)
			(1
				(proc0_14 600 0 108 67 -1 20)
				(gLarry setCycle: Fwd)
				(= seconds 5)
			)
			(2
				(if gTheNewDialog (gTheNewDialog dispose:))
				(gLarry setLoop: 1 setCel: 0 setCycle: CT 1 1 self)
			)
			(3
				(slap play:)
				(gLarry setCycle: End self)
			)
			(4
				(proc0_14 600 1 67 -1 20)
				(gLongSong fade: 0 15 12 1)
				(gLarry dispose:)
				(self setScript: sExitLimo)
			)
		)
	)
)

(instance sExitLimo of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= gGNumber (global2 south?))
					(global2 drawPic: 610 100)
					(flagOne init: cycleSpeed: 18 setCycle: Fwd)
					(flagTwo init: cycleSpeed: 24 setCycle: Fwd)
					(revolvingDoor init: cycleSpeed: 10)
					(limo init: approachVerbs: 3)
					(hydrant init:)
					(car init:)
					(shillSign init:)
					(fReflection init:)
				)
				(gLongSong2
					number: 251
					setLoop: -1
					setVol: 127
					flags: 1
					play:
				)
				(= ticks 90)
			)
			(1
				(gLongSong number: 191 setLoop: 1 play:)
				(= ticks 80)
			)
			(2
				(gLarry
					init:
					setLoop: gStopGroop
					normalize: 572
					setStep: 2 1
					posn: 119 182
					setHeading: 0
					setMotion: MoveTo 119 180 self
				)
			)
			(3 (= ticks 30))
			(4
				(gLongSong number: 192 setLoop: 1 play:)
				(= ticks 100)
			)
			(5
				(proc0_3)
				(if (== gGNumber (global2 south?)) (self dispose:))
				(= seconds 4)
			)
			(6
				(self dispose:)
				(if
					(proc255_0
						600
						2
						81
						{Save}
						1
						81
						{Nah, Why Bother?}
						0
						80
						{AL says}
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
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong number: 191 setLoop: 1 play:)
				(= ticks 80)
			)
			(1
				((gLarry looper?) dispose:)
				(gLarry
					setCycle: 0
					setPri: 9
					setMotion: MoveTo (gLarry x?) (+ (gLarry y?) 10) self
				)
			)
			(2
				(gLarry dispose:)
				(= ticks 30)
			)
			(3
				(gLongSong number: 192 setLoop: 1 play:)
				(= ticks 100)
			)
			(4
				(global2 newRoom: 200)
				(self dispose:)
			)
		)
	)
)

(instance flagOne of Prop
	(properties
		x 98
		y 161
		description {the flag}
		lookStr {The Shill Building's management is so patriotic!}
		view 610
	)
)

(instance flagTwo of Prop
	(properties
		x 220
		y 159
		description {the flag}
		lookStr {The Shill Building's management is so patriotic!}
		view 610
		loop 1
	)
)

(instance revolvingDoor of Door
	(properties
		x 163
		y 178
		description {the revolving door}
		approachX 172
		approachY 179
		lookStr {This revolving door is a highlight of the entrance to the Shill building.}
		view 610
		loop 4
		entranceTo 620
		openSnd 611
		closeSnd 611
		moveToX 165
		moveToY 179
	)
	
	(method (init)
		(if (== gGNumber (global2 north?)) (self setLoop: 3))
		(super init: &rest)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(self setPri: 14 setLoop: 2)
				(super doVerb: theVerb &rest)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (cue)
		(super cue:)
		(if (== state 0)
			(self setLoop: 4)
			(gLarry posn: (- approachX 14) (- approachY 1) show:)
		)
	)
	
	(method (open)
		(gLarry hide: posn: moveToX moveToY)
		(super open:)
	)
)

(instance slap of Sound
	(properties
		number 601
	)
)

(instance limo of Feature
	(properties
		x 109
		y 176
		nsTop 169
		nsLeft 53
		nsBottom 183
		nsRight 166
		description {the limousine}
		approachX 119
		approachY 180
		lookStr {Your limousine waits for your return. Inside, your driver is still smarting from your arrival! You feel sure he has learned his lesson.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(global2 setScript: sEnterLimo)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hydrant of Feature
	(properties
		x 21
		y 178
		nsTop 168
		nsLeft 1
		nsBottom 189
		nsRight 41
		description {the fire hydrant}
		lookStr {How do dogs spell relief? "H-Y-D-R-A-N-T"}
	)
)

(instance car of Feature
	(properties
		x 272
		y 168
		nsTop 147
		nsLeft 225
		nsBottom 189
		nsRight 319
		description {the car}
		lookStr {You wonder which Shill Building office drone drives such a junky car?}
	)
)

(instance shillSign of Feature
	(properties
		x 160
		y 133
		nsTop 128
		nsLeft 121
		nsBottom 138
		nsRight 199
		description {the Shill sign}
		sightAngle 40
		lookStr {Patti, it says "SHILL."}
	)
)

(instance fReflection of Feature
	(properties
		x 175
		y 176
		z 107
		nsTop 57
		nsLeft 160
		nsBottom 82
		nsRight 190
		description {the reflection}
		sightAngle 40
		lookStr {Don't stare at the sun, Patti! You'll go blind!}
	)
)
