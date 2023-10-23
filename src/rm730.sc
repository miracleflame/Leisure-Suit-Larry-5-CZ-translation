;;; Sierra Script 1.0 - (do not remove this comment)
(script# 730)
(include sci.sh)
(use Main)
(use LLRoom)
(use RTRandCycle)
(use n940)
(use PolyPath)
(use Polygon)
(use CueObj)
(use n958)
(use Sound)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm730 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)
(procedure (localproc_1a84)
	(runway init:)
	(stage init:)
)

(procedure (localproc_1a95)
	(runway dispose:)
	(stage dispose:)
)

(instance rm730 of LLRoom
	(properties
		lookStr {The Ballroom is pulsating with people--all of them men. "Where are the women?" you wonder.}
		picture 730
	)
	
	(method (init)
		(gLarry init:)
		(proc0_2)
		(switch gGNumber
			(710
				(self setScript: sFromSouth)
			)
			(else 
				(gLarry get: 17)
				(= global153 5000)
				(proc0_7 3)
				(proc0_3)
				(self setScript: sFromSouth)
			)
		)
		(super init:)
		(bouncer init: approachVerbs: 5 4)
		(localproc_1a84)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init: 0 0 319 0 319 189 16 189 16 183 33 164 0 164
					yourself:
				)
		)
		(gLongSong number: 738 setLoop: -1 flags: 1 play: 127)
		(cond 
			((proc0_6 3)
				(proc958_0 128 1731 552)
				(proc958_0 132 744 743)
				(= local2 1)
				(ring init: stopUpd:)
				(ropes init: stopUpd:)
			)
			((proc0_6 5) (= local2 0))
			(else (= local2 2) (Load rsSOUND 743) (proc958_0 128 733 738))
		)
		(Load rsVIEW 731)
	)
	
	(method (doit)
		(super doit:)
		(if
		(and (gLarry mover?) (== (global2 curPic?) 738))
			(gLarry setMotion: 0)
			(self doVerb:)
		)
		(cond 
			(script)
			((gLarry script?))
			((gLarry edgeHit?)
				(gLarry edgeHit: 0)
				(proc0_2)
				(global2 setScript: sLeave)
			)
			((and (gLarry sitting?) (gLarry mover?))
				(if (== (global2 curPic?) 738)
					(self doVerb:)
				else
					(proc0_2)
					(gLarry setScript: sStandUp)
				)
			)
			(
				(and
					(gCast contains: lana)
					(not local1)
					(== (lana script?) sTaunt)
				)
				(gLarry setPri: 14 setScript: sLarryIntoRing)
			)
			(
			(and (< (gLarry y?) 137) (not (gLarry sitting?))) (gLarry setScript: sSitDown))
		)
	)
	
	(method (doVerb theVerb param2)
		(if (== (global2 curPic?) 738)
			(gCast eachElementDo: #show)
			(global2 drawPic: 730 setScript: 0)
			(herEyes dispose:)
			(herMouth dispose:)
			(proc0_22 0)
			(localproc_1a84)
			(sContest start: (sContest state?))
			(contestant setScript: sContest)
			1
		else
			(super doVerb: theVerb param2 &rest)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 740) (gLongSong fade:))
		(super newRoom: newRoomNumber)
	)
)

(instance sLeave of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLarry
					setMotion: MoveTo (- (gLarry x?) 20) (+ (gLarry y?) 25) self
				)
			)
			(1 (global2 newRoom: 710))
		)
	)
)

(instance sFromSouth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLarry
					normalize:
					posn: -30 222
					setMotion: PolyPath 8 188 self
				)
			)
			(1 (gLarry setHeading: 0 self))
			(2 (proc0_3) (self dispose:))
		)
	)
)

(instance sSitDown of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 731
					setLoop: 1
					setCel: 0
					setPri: 14
					setCycle: End
					setMotion: MoveTo 111 130 self
				)
			)
			(1
				(gLarry
					x: 111
					y: 123
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(gLarry sitting: 1)
				(proc0_3)
				(cond 
					((== local2 1)
						(if local1 (= local4 0))
						(if (not (gCast contains: lana))
							(lana init: setScript: sWrestle)
						)
					)
					((not (gCast contains: contestant)) (contestant init: setScript: sContest))
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
			(0
				(proc0_2)
				(gLarry sitting: 0)
				(gLarry setCycle: Beg self)
			)
			(1
				(gLarry posn: (gLarry x?) (+ (gLarry y?) 7))
				(= cycles 1)
			)
			(2
				(gLarry
					setLoop: 2
					setCel: 0
					setCycle: End
					setMotion: PolyPath 80 137 self
				)
			)
			(3
				(proc0_3)
				(gLarry normalize:)
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
				)
				(self dispose:)
			)
		)
	)
)

(instance sWrestle of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(lana
					setLoop: 0
					setCycle: Fwd
					setMotion: MoveTo 265 82 self
				)
			)
			(1
				(lana setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(soundFX number: 743 play:)
				(lana setLoop: 2 setCel: 0 setCycle: CT 7 1 self)
			)
			(3
				(robe init: setCycle: End)
				(lana
					setLoop: 4
					setCycle: Fwd
					setMotion: MoveTo 223 82 self
				)
			)
			(4
				(lana
					x: 203
					y: 65
					setLoop: 5
					setCel: 0
					setPri: 7
					cycleSpeed: 4
					setCycle: End self
				)
			)
			(5
				(soundFX number: 744 play:)
				(lana setLoop: 4 x: 174 y: 82)
				(= cycles 2)
			)
			(6
				(lana cycleSpeed: 6 setScript: sTaunt)
				(self dispose:)
			)
		)
	)
)

(instance sContest of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_14 730 0)
				(= seconds 3)
			)
			(1
				(contestant setCycle: Walk setMotion: MoveTo 250 82 self)
			)
			(2
				(soundFX number: 743 play:)
				(contestant setCycle: Walk setMotion: MoveTo 160 82 self)
			)
			(3
				(contestant
					setLoop: 2
					setCel: 0
					setMotion: 0
					cycleSpeed: 8
					moveSpeed: 8
					setCycle: End self
				)
			)
			(4
				(contestant setCycle: Beg self)
			)
			(5 (= seconds 2))
			(6
				(contestant
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo (- (contestant x?) 25) (contestant y?) self
				)
			)
			(7
				(contestant setLoop: 3 setCel: 255 setCycle: Beg self)
			)
			(8 (= seconds 2))
			(9
				(contestant
					setLoop: -1
					cycleSpeed: 6
					moveSpeed: 6
					setCycle: Walk
					setMotion: MoveTo 360 82 self
				)
			)
			(10
				(proc0_14 730 1)
				(gLongSong fade: 0 10 5 1)
				(self dispose:)
			)
		)
	)
)

(instance sLarryIntoRing of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(if (not (gLarry sitting?))
					(gLarry setMotion: PolyPath 70 132 self)
				else
					(= cycles 3)
				)
			)
			(1
				(if (not (gLarry sitting?))
					(gLarry
						view: 731
						setLoop: 1
						setCel: 0
						setPri: 14
						setCycle: End
						setMotion: MoveTo 101 130 self
					)
				else
					(= cycles 3)
				)
			)
			(2
				(gLarry
					view: 552
					sitting: 0
					setLoop: -1
					setCycle: Walk
					cycleSpeed: 6
					moveSpeed: 6
					setMotion: MoveTo 90 123 self
				)
			)
			(3
				(ropes ignoreActors: 1)
				(ring ignoreActors: 1)
				(gLarry
					view: 552
					setLoop: 3
					setCycle: Walk
					setMotion: MoveTo 109 102 self
				)
			)
			(4
				(gLarry view: 731 setCel: 0 setCycle: CT 7 1 self)
			)
			(5
				(gLarry
					setPri: (+ (ring priority?) 1)
					setCycle: End self
				)
			)
			(6
				(soundFX number: 744 play: self)
			)
			(7 (global2 newRoom: 740))
		)
	)
)

(instance sTaunt of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (lana x?) 184)
					(lana
						setLoop: 6
						setCycle: Fwd
						setMotion: MoveTo 115 82 self
					)
				else
					(lana
						setLoop: 7
						setCycle: Fwd
						setMotion: MoveTo 184 82 self
					)
				)
			)
			(1
				(lana setLoop: 8 setCel: 0 setCycle: End self)
			)
			(2
				(switch (Random 0 5)
					(0 (proc0_18 Lana 730 2 108))
					(1 (proc0_18 Lana 730 3 108))
					(2 (proc0_18 Lana 730 4 108))
					(3 (proc0_18 Lana 730 5 108))
					(4 (proc0_18 Lana 730 6 108))
					(5 (proc0_18 Lana 730 7 108))
				)
				(proc0_17 (Random 10 20) 1 self)
			)
			(3 (self changeState: 0))
		)
	)
)

(instance sCloseup of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 2 4)))
			(1
				(herEyes init: setCel: 0 setCycle: Beg self)
			)
			(2 (= seconds (Random 2 4)))
			(3
				(herMouth init: setCel: 0 setCycle: End self)
			)
			(4 (= seconds (Random 1 3)))
			(5
				(herMouth setCycle: Beg self)
			)
			(6 (= seconds (Random 2 4)))
			(7
				(herEyes init: setCel: 0 setCycle: Beg self)
			)
			(8
				(= start (* 2 (Random 0 1)))
				(self init:)
			)
		)
	)
)

(instance contestant of Actor
	(properties
		x 340
		y 82
		description {Jennifer Jiggle}
		view 733
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_10 8 135)
				(gCast eachElementDo: #hide)
				(global2 drawPic: 738 setScript: sCloseup)
				(proc0_22 1)
				(localproc_1a95)
				(self setCycle: 0 setMotion: 0)
			)
			(5 (proc0_18 gLarry 730 8))
			(4 (proc0_14 730 9))
			(10 (proc0_14 730 10))
			(else 
				(super doVerb: theVerb param2)
			)
		)
	)
)

(instance lana of Actor
	(properties
		x 340
		y 82
		description {Lana Luscious}
		lookStr {Lana looks much different, now that she's out of her roller skates and into her element!}
		view 734
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 730 11))
			(5 (proc0_18 gLarry 730 12))
			(10 (proc0_14 730 13))
			(else 
				(super doVerb: theVerb param2)
			)
		)
	)
)

(instance robe of Prop
	(properties
		x 300
		y 55
		description {her robe}
		lookStr {She threw away her robe!}
		view 734
		loop 3
	)
)

(instance ring of View
	(properties
		x 147
		y 107
		description {the mud wrestling ring}
		lookStr {Welcome to "Tramp This! Mud Night Madness" mud wrestling ring.}
		view 730
		priority 4
		signal $4010
	)
)

(instance ropes of View
	(properties
		x 147
		y 107
		description {the ropes}
		lookStr {Welcome to "Tramp This! Mud Night Madness" mud wrestling ring.}
		view 730
		cel 1
		priority 8
		signal $4010
	)
)

(instance bouncer of Actor
	(properties
		x 16
		y 161
		description {the bouncer}
		sightAngle 40
		approachX 16
		approachY 168
		lookStr {You feel certain this bouncer is not nearly as wise as you in the ways of women.}
		view 732
		signal $4000
	)
	
	(method (doVerb theVerb param2 &tmp [temp0 100])
		(switch theVerb
			(2
				(if (not local3)
					(proc0_14 730 14)
				else
					(proc0_14 730 15)
					(proc0_14 730 16 67 -1 185)
				)
			)
			(10 (proc0_14 730 17))
			(5
				(switch local2
					(0
						(proc0_18 The_Bouncer 730 18 108)
					)
					(2
						(cond 
							((< (gLarry y?) y) (proc0_18 The_Bouncer 730 19 108))
							((Random 0 1) (proc0_18 The_Bouncer 730 20 108))
							(else (proc0_18 The_Bouncer 730 21 108))
						)
					)
					(1
						(if (< (gLarry y?) y)
							(proc0_18 The_Bouncer 730 22 108)
						else
							(proc0_18 The_Bouncer 730 23 108)
						)
					)
				)
			)
			(4
				(switch param2
					(17
						(cond 
							(
								(not
									(= local3
										(switch local2
											(0 0)
											(2 25)
											(1
												(if (gCast contains: lana)
													500
												else
													(proc940_0
														{"What's it gonna be?"}
														106
														80
														{The Bouncer}
														81
														{I'll just watch}
														25
														81
														{Lemme at 'em!}
														500
													)
												)
											)
										)
									)
								)
							)
							(local4
								(if local1
									(proc0_18 The_Bouncer 730 24 108)
								else
									(proc0_18 The_Bouncer 730 25 108)
								)
							)
							((gLarry sitting?) (gLarry setScript: sStandUp))
							((> local3 global153)
								(Format @temp0 730 26 global153)
								(proc0_18 gLarry @temp0)
								(proc0_14 730 27)
								(proc0_18 The_Bouncer 730 28 108)
							)
							(else
								(if (== local3 25)
									(proc0_18 gLarry 730 29)
									(proc0_18 The_Bouncer 730 30 108)
									(= local1 1)
								else
									(proc0_10 12 134)
									(proc0_18 gLarry 730 31)
									(if (gCast contains: lana)
										(proc0_18 The_Bouncer 730 32 108)
									else
										(proc0_18 The_Bouncer 730 33 108)
									)
									(= local1 0)
								)
								(= global153 (- global153 local3))
								(= local4 1)
								(if (not (gCast contains: lana))
									(self setCycle: End self approachX: 43 approachY: 153)
								)
							)
						)
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
	
	(method (cue)
		(self setCel: 0 posn: (- x 16) y stopUpd:)
		((global2 obstacles?) dispose:)
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
						18
						189
						18
						181
						93
						130
						116
						130
						116
						121
						68
						121
						35
						138
						35
						164
						0
						164
					yourself:
				)
		)
	)
)

(instance herEyes of Prop
	(properties
		x 150
		y 57
		view 738
		signal $4000
	)
	
	(method (doVerb theVerb)
		(global2 doVerb: theVerb)
	)
)

(instance herMouth of Prop
	(properties
		x 150
		y 57
		view 738
		loop 1
		signal $4000
	)
	
	(method (doVerb theVerb)
		(global2 doVerb: theVerb)
	)
)

(instance The_Bouncer of Talker
	(properties
		nsTop 15
		nsLeft 20
		view 1732
		loop 3
		viewInPrint 1
		name "The Bouncer"
	)
	
	(method (init)
		(= bust bouncerBust)
		(= eyes bouncerEyes)
		(= mouth bouncerMouth)
		(super init: &rest)
	)
)

(instance bouncerBust of Prop
	(properties
		view 1732
		loop 1
	)
)

(instance bouncerEyes of Prop
	(properties
		view 1732
		loop 2
		cycleSpeed 20
	)
)

(instance bouncerMouth of Prop
	(properties
		nsTop 53
		nsLeft 9
		view 1732
		cycleSpeed 8
	)
)

(instance Lana of Talker
	(properties
		nsTop 15
		nsLeft 15
		view 1731
		loop 3
		viewInPrint 1
	)
	
	(method (init)
		(= bust lanaBust)
		(= eyes lanaEyes)
		(= mouth lanaMouth)
		(super init: &rest)
	)
)

(instance lanaBust of Prop
	(properties
		view 1731
		loop 1
	)
)

(instance lanaEyes of Prop
	(properties
		nsTop 31
		nsLeft 29
		view 1731
		loop 2
		cycleSpeed 30
	)
)

(instance lanaMouth of Prop
	(properties
		nsTop 40
		nsLeft 23
		view 1731
	)
)

(instance stage of Feature
	(properties
		x 152
		y 85
		nsTop 67
		nsLeft 91
		nsBottom 103
		nsRight 214
		description {the stage}
		sightAngle 40
		lookStr {The stage is where all the action takes place.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 730 34))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance runway of Feature
	(properties
		x 260
		y 83
		nsTop 77
		nsLeft 202
		nsBottom 89
		nsRight 319
		description {the runway}
		sightAngle 40
		lookStr {You wonder what sort of babes must lie in wait down that runway.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 730 35))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance soundFX of Sound
	(properties)
)
