;;; Sierra Script 1.0 - (do not remove this comment)
(script# 790)
(include sci.sh)
(use Main)
(use LLRoom)
(use RTRandCycle)
(use Polygon)
(use CueObj)
(use n958)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm790 0
)

(local
	local0
)
(instance rm790 of LLRoom
	(properties
		lookStr {You are inside the only open shop along the entire boardwalk. You wonder why this place doesn't join in the celebration of Donald Tramp's birthday.}
		picture 790
		south 760
	)
	
	(method (init)
		(proc958_0 128 1792 792)
		(gLarry init: normalize: actions: sitActions)
		(switch gGNumber
			(south
				(proc0_2)
				(gLarry x: 160)
				(global2 setScript: sFromSouth)
			)
			(else 
				(proc0_3)
				(gLarry posn: 160 160 edgeHit: 0)
			)
		)
		(super init:)
		(gLongSong number: 790 loop: -1 flags: 1 play:)
		(skates init:)
		(curtain init: stopUpd:)
		(poster1 init:)
		(poster2 init:)
		(poster3 init:)
		(poster4 init:)
		(poster5 init:)
		(poster6 init:)
		(poster7 init:)
		(box init:)
		(light init:)
		(desk init:)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init: 0 0 319 0 319 189 250 189 250 137 224 120 91 120 63 151 63 189 0 189
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 179 144 217 144 238 157 198 157
					yourself:
				)
		)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(script)
			(
				(and
					(proc0_5 gLarry 2)
					(not (gCast contains: Ivana_a))
				)
				(proc0_2)
				(Ivana_a init: approachVerbs: 4 5 3 setCycle: Walk)
				(global2 setScript: sIvanaEnters)
			)
		)
	)
	
	(method (dispose)
		(if (gLarry has: 18) (proc0_7 6))
		(gLongSong fade:)
		(super dispose:)
	)
)

(instance sIvanaEnters of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Ivana_a setMotion: MoveTo 121 107 self)
			)
			(1
				(curtain setCycle: End curtain)
				(Ivana_a setMotion: MoveTo 121 111 self)
			)
			(2
				(Ivana_a setPri: 6 setMotion: MoveTo 150 111 self)
			)
			(3
				(Ivana_a setHeading: 180 self)
			)
			(4
				(proc0_18 Ivana_b 790 0 108)
				(Ivana_a stopUpd:)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance sFromSouth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLarry y: 250 setMotion: MoveTo 160 180 self)
			)
			(1 (proc0_3) (self dispose:))
		)
	)
)

(instance sTalk of Script
	(properties)
	
	(method (changeState newState &tmp temp0 [temp1 80])
		(switch (= state newState)
			(0
				(= local0 1)
				(proc0_18 gLarry 790 1 67 -1 185)
				(proc0_18 Ivana_b 790 2 108 139 self)
			)
			(1
				(Format @temp1 790 3 250)
				(proc0_18 Ivana_b @temp1 108 139 self)
			)
			(2
				(proc0_18 gLarry 790 4 67 -1 185)
				(proc0_18 Ivana_b 790 5 108 139 self)
			)
			(3 (proc0_3) (self dispose:))
		)
	)
)

(instance sCamcorder of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_18 gLarry 790 6 67 -1 185)
				(proc0_18 gLarry 790 7 67 -1 185)
				(proc0_10 8 141)
				(proc0_18 Ivana_b 790 8 108 139 self)
			)
			(1
				(proc0_14 790 9)
				(gLarry put: 0 790 get: 18)
				(proc0_3)
				(gIconBar curIcon: (gIconBar at: 0))
				(gGame setCursor: ((gIconBar curIcon?) cursor?))
				(self dispose:)
			)
		)
	)
)

(instance sRollerblades of Script
	(properties)
	
	(method (changeState newState &tmp temp0 [temp1 80])
		(switch (= state newState)
			(0
				(proc0_18 gLarry 790 10 67 -1 185)
				(proc0_18 Ivana_b 790 11 108 139 self)
			)
			(1
				(proc0_10 3 142)
				(if (gLarry has: 0)
					(= temp0 (Random 100 240))
					(Format @temp1 790 12 temp0)
					(proc0_18 Ivana_b @temp1 108)
					(gLarry put: 18 0 get: 17)
					(= global153 (+ global153 (- 250 temp0)))
				else
					(proc0_18 Ivana_b 790 13 108)
					(gLarry put: 18 0 get: 0)
				)
				(proc0_3)
				(gIconBar curIcon: (gIconBar at: 0))
				(gGame setCursor: ((gIconBar curIcon?) cursor?))
				(self dispose:)
			)
		)
	)
)

(instance Ivana_a of Actor
	(properties
		x 147
		y 107
		description {Ivana Tramp}
		sightAngle 40
		approachX 130
		approachY 120
		lookStr {Ivana Tramp (known locally as "Wheels, The Blademaster") has plummeted several social levels since her divorce from The Donald.}
		view 792
		priority 3
		signal $0010
	)
	
	(method (doVerb theVerb param2 &tmp temp0 [temp1 80])
		(switch theVerb
			(3 (proc0_14 790 14))
			(10 (proc0_14 790 15))
			(5
				(cond 
					((gLarry has: 18)
						(if (proc0_6 6)
							(proc0_18 Ivana_b 790 16 108)
						else
							(proc0_18 Ivana_b 790 17 108)
						)
					)
					((proc0_6 6) (proc0_18 Ivana_b 790 18 108))
					((not local0) (proc0_2) (global2 setScript: sTalk))
					(else (proc0_18 Ivana_b 790 19 108))
				)
			)
			(4
				(switch param2
					(17
						(cond 
							((and (gLarry has: 18) (not (proc0_6 6))) (proc0_18 Ivana_b 790 20 108))
							((proc0_6 6) (proc0_18 Ivana_b 790 21 108))
							((not local0) (proc0_2) (global2 setScript: sTalk))
							((< global153 250)
								(Format @temp1 790 22 global153)
								(proc0_18 gLarry @temp1 67 -1 185)
								(proc0_18 Ivana_b 790 23 108)
							)
							(else
								(Format @temp1 790 24 250)
								(proc0_18 gLarry @temp1 67 -1 185)
								(proc0_10 4 143)
								(proc0_18 Ivana_b 790 25 108)
								(if (not (= global153 (- global153 250)))
									(gLarry put: 17 0)
								)
								(gLarry get: 18)
								(gIconBar curIcon: (gIconBar at: 0))
								(gGame setCursor: ((gIconBar curIcon?) cursor?))
							)
						)
					)
					(0
						(cond 
							((proc0_6 6) (proc0_18 Ivana_b 790 26 108))
							((gLarry has: 18) (proc0_18 Ivana_b 790 27 108))
							(else (proc0_2) (global2 setScript: sCamcorder))
						)
					)
					(18
						(if (proc0_6 6)
							(proc0_2)
							(global2 setScript: sRollerblades)
						else
							(proc0_18 Ivana_b 790 28 108)
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
)

(instance skates of Feature
	(properties
		x 177
		y 69
		nsTop 49
		nsLeft 148
		nsBottom 90
		nsRight 206
		description {the skates}
		sightAngle 40
		lookStr {From the many pairs of in-line skates on this rack, you feel safe in predicting that this store rents skates.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 790 29))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance curtain of Prop
	(properties
		x 123
		y 94
		description {the curtain}
		sightAngle 40
		lookStr {A beaded curtain blocks your view of the skate shop's back room.}
		view 790
		signal $4000
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 790 30))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (cue)
		(super cue:)
		(self stopUpd:)
	)
)

(instance poster1 of Feature
	(properties
		x 64
		y 42
		nsTop 31
		nsLeft 54
		nsBottom 54
		nsRight 75
		description {the poster}
		sightAngle 40
		lookStr {You presume this poster advertises an amusement park for insects.}
	)
)

(instance poster2 of Feature
	(properties
		x 76
		y 75
		nsTop 51
		nsLeft 62
		nsBottom 100
		nsRight 90
		description {the poster}
		sightAngle 40
		lookStr {So that's what Ivana looked like when she was a redhead!}
	)
)

(instance poster3 of Feature
	(properties
		x 61
		y 113
		nsTop 96
		nsLeft 50
		nsBottom 131
		nsRight 73
		description {the poster}
		sightAngle 40
		lookStr {To demonstrate how good these skates are, the lady in the poster is eating one.}
	)
)

(instance poster4 of Feature
	(properties
		x 230
		y 75
		nsTop 44
		nsLeft 221
		nsBottom 82
		nsRight 240
		description {the poster}
		sightAngle 40
		lookStr {This poster advertises roller skate odor eaters.}
	)
)

(instance poster5 of Feature
	(properties
		x 238
		y 44
		nsTop 66
		nsLeft 225
		nsBottom 103
		nsRight 252
		description {the poster}
		sightAngle 40
		lookStr {"Keep your in-line skates in line with the all new `Edlin,' from Ed's Skate Aligning Corp."}
	)
)

(instance poster6 of Feature
	(properties
		x 253
		y 37
		nsTop 25
		nsLeft 246
		nsBottom 50
		nsRight 261
		description {the poster}
		sightAngle 40
		lookStr {"Better skating, no waiting."}
	)
)

(instance poster7 of Feature
	(properties
		x 250
		y 106
		nsTop 92
		nsLeft 241
		nsBottom 121
		nsRight 259
		description {the poster}
		sightAngle 40
		lookStr {"Nuclear Blades" for those who want to go REALLY fast!}
	)
)

(instance light of Feature
	(properties
		x 165
		y 37
		nsTop 30
		nsLeft 147
		nsBottom 44
		nsRight 184
		description {the light}
		sightAngle 40
		lookStr {Ivana has thoughtfully replaced the standard 60-watt bulb with this new 250-watt halogen.}
	)
)

(instance desk of Feature
	(properties
		x 158
		y 105
		nsTop 91
		nsLeft 90
		nsBottom 120
		nsRight 227
		description {the counter}
		sightAngle 40
		lookStr {Across this counter pass the world's sharpest `blades!'}
	)
)

(instance box of Feature
	(properties
		x 205
		y 144
		nsTop 133
		nsLeft 188
		nsBottom 156
		nsRight 223
		description {the box}
		sightAngle 40
		lookStr {A wooden crate resides incongruously in the center of the floor.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 790 31))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Ivana_b of Talker
	(properties
		nsTop 15
		nsLeft 20
		view 1792
		loop 3
		viewInPrint 1
	)
	
	(method (init)
		(= bust ivanaBust)
		(= eyes ivanaEyes)
		(= mouth ivanaMouth)
		(super init: &rest)
	)
)

(instance ivanaBust of Prop
	(properties
		view 1792
		loop 1
	)
)

(instance ivanaEyes of Prop
	(properties
		nsTop 41
		nsLeft 24
		view 1792
		loop 2
		cycleSpeed 30
	)
)

(instance ivanaMouth of Prop
	(properties
		nsTop 41
		nsLeft 24
		view 1792
		cycleSpeed 8
	)
)

(instance sitActions of Actions
	(properties)
	
	(method (doVerb theVerb param2)
		(return
			(switch theVerb
				(4
					(switch param2
						(18 (proc0_14 790 32))
						(else  (return 0))
					)
				)
				(else  (return 0))
			)
		)
	)
)
