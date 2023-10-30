;;; Sierra Script 1.0 - (do not remove this comment)
(script# 390)
(include sci.sh)
(use Main)
(use LLRoom)
(use CueObj)
(use n958)
(use Sound)
(use Cycle)
(use User)
(use PicView)
(use Obj)

(public
	rm390 0
)

(local
	local0
	local1
	local2
	local3
	local4
)
(instance rm390 of LLRoom
	(properties
		picture 390
	)
	
	(method (init)
		(super init:)
		(proc958_0 135 global175 global174)
		(larry init: setCycle: End larry)
		(plane init: setScript: sPlane)
		(panel1 init: setCycle: Fwd)
		(panel2 init: setCycle: Fwd)
		(panel3 init: setCycle: Fwd)
		(panel4 init: setCycle: Fwd)
		(panel5 init: setCycle: Fwd)
		(panel6 init: setCycle: Fwd)
		(panel7 init: setCycle: Fwd)
		(panel8 init: setCycle: Fwd)
		(cloud init: setScript: sCloud)
		(cloud2 init: setScript: sCloud2)
		(frontCloud init: setScript: sFrontCloud)
		(frontCloud2 init: setScript: sFrontCloud2)
		(wheel init: setCycle: Fwd)
		(wheel2 init: setCycle: Fwd)
		(windows init:)
		(console init:)
		(throttle init:)
		(bigLarry init:)
		(thePlane init:)
		(self setScript: sPlaneCartoon)
		(proc0_13 310)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 390 0))
			(5
				(proc0_14 390 1 33 global174 80 {Ty})
			)
			(4 (proc0_14 390 2))
			(10 (proc0_14 390 3))
			(3
				(switch (++ local2)
					(1
						(proc0_14 390 4)
						(proc0_14 390 5 67 -1 185)
					)
					(2 (proc0_14 390 6))
					(3 (proc0_14 390 7))
					(4 (proc0_14 390 8))
					(5 (proc0_14 390 9))
					(else 
						(if (== (sPlaneCartoon state?) 5)
							(global2 setScript: sAutoPilot)
						else
							(proc0_14 390 10)
						)
					)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(gLongSong stop:)
		(gLongSong2 stop:)
		(super newRoom: newRoomNumber)
	)
)

(instance sPlane of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(plane setLoop: 1 cycleSpeed: 1 setCycle: Fwd)
				(= cycles (Random 20 30))
			)
			(1
				(plane
					setLoop: 2
					setCel: 0
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(2
				(plane setLoop: 1 cycleSpeed: 1 setCycle: Fwd)
				(= cycles (Random 20 30))
			)
			(3
				(plane
					setLoop: 3
					setCel: 0
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(4 (self init:))
		)
	)
)

(instance panel1 of Prop
	(properties
		x 14
		y 18
		description {panel}
		view 390
		priority 4
		signal $4810
		detailLevel 1
	)
	
	(method (doVerb theVerb param2)
		(global2 doVerb: theVerb param2 &rest)
	)
)

(instance panel2 of Prop
	(properties
		x 147
		y 18
		description {panel}
		view 390
		loop 1
		cel 2
		priority 4
		signal $4810
		detailLevel 1
	)
	
	(method (doVerb theVerb param2)
		(global2 doVerb: theVerb param2 &rest)
	)
)

(instance panel3 of Prop
	(properties
		x 98
		y 18
		description {panel}
		view 390
		loop 2
		cel 1
		priority 4
		signal $4810
		detailLevel 2
	)
	
	(method (doVerb theVerb param2)
		(global2 doVerb: theVerb param2 &rest)
	)
)

(instance panel4 of Prop
	(properties
		x 76
		y 92
		description {panel}
		view 390
		loop 3
		cel 4
		priority 4
		signal $4810
		detailLevel 2
	)
	
	(method (doVerb theVerb param2)
		(global2 doVerb: theVerb param2 &rest)
	)
)

(instance panel5 of Prop
	(properties
		x 192
		y 95
		description {panel}
		view 390
		loop 4
		cel 2
		priority 4
		signal $4810
		detailLevel 3
	)
	
	(method (doVerb theVerb param2)
		(global2 doVerb: theVerb param2 &rest)
	)
)

(instance panel6 of Prop
	(properties
		x 192
		y 18
		description {panel}
		view 390
		loop 5
		cel 5
		priority 4
		signal $4810
		detailLevel 3
	)
	
	(method (doVerb theVerb param2)
		(global2 doVerb: theVerb param2 &rest)
	)
)

(instance panel7 of Prop
	(properties
		x 283
		y 13
		description {panel}
		view 390
		loop 6
		cel 2
		priority 4
		signal $4810
		detailLevel 4
	)
	
	(method (doVerb theVerb param2)
		(global2 doVerb: theVerb param2 &rest)
	)
)

(instance panel8 of Prop
	(properties
		x 280
		y 83
		description {panel}
		view 390
		loop 7
		cel 1
		priority 4
		signal $4810
		detailLevel 4
	)
	
	(method (doVerb theVerb param2)
		(global2 doVerb: theVerb param2 &rest)
	)
)

(instance wheel of Prop
	(properties
		x 92
		y 66
		description {jaømo}
		view 390
		loop 8
		priority 6
		signal $4810
		cycleSpeed 1
	)
	
	(method (doVerb theVerb param2)
		(global2 doVerb: theVerb param2 &rest)
	)
)

(instance wheel2 of Prop
	(properties
		x 223
		y 65
		description {jaømo}
		view 390
		loop 8
		priority 6
		signal $4810
		cycleSpeed 1
	)
	
	(method (doVerb theVerb param2)
		(global2 doVerb: theVerb param2 &rest)
	)
)

(instance cloud of Actor
	(properties
		description {oblak}
		view 392
		priority 2
		signal $4810
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 390 11))
			(3
				(proc0_14 390 12)
				(proc0_14 390 13 67 -1 185)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance cloud2 of Actor
	(properties
		description {oblak}
		view 392
		priority 2
		signal $4810
	)
	
	(method (doVerb theVerb param2)
		(cloud doVerb: theVerb param2 &rest)
	)
)

(instance frontCloud of Actor
	(properties
		description {oblak}
		yStep 25
		view 392
		cel 3
		priority 2
		signal $5810
		xStep 25
	)
	
	(method (doVerb theVerb param2)
		(cloud doVerb: theVerb param2 &rest)
	)
)

(instance frontCloud2 of Actor
	(properties
		description {oblak}
		yStep 25
		view 392
		cel 3
		priority 2
		signal $5810
		xStep 25
	)
	
	(method (doVerb theVerb param2)
		(cloud doVerb: theVerb param2 &rest)
	)
)

(instance sFrontCloud of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(frontCloud hide:)
				(= cycles (Random 2 4))
			)
			(1
				(frontCloud
					show:
					setCel: (Random 0 3)
					setStep: (+ (frontCloud xStep?) 2) (+ (frontCloud yStep?) 2)
				)
				(switch (Random 1 4)
					(1
						(frontCloud posn: 144 19 setMotion: MoveTo 0 67 self)
					)
					(2
						(frontCloud posn: 141 44 setMotion: MoveTo 0 11 self)
					)
					(3
						(frontCloud posn: 144 19 setMotion: MoveTo -24 40 self)
					)
					(4
						(frontCloud posn: 141 44 setMotion: MoveTo -24 40 self)
					)
				)
			)
			(2 (self init:))
		)
	)
)

(instance sFrontCloud2 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(frontCloud2 hide:)
				(= cycles (Random 2 4))
			)
			(1
				(frontCloud2
					show:
					setCel: (Random 0 3)
					setStep: (+ (frontCloud2 xStep?) 2) (+ (frontCloud2 yStep?) 2)
				)
				(switch (Random 1 4)
					(1
						(frontCloud2 posn: 177 20 setMotion: MoveTo 319 67 self)
					)
					(2
						(frontCloud2 posn: 177 20 setMotion: MoveTo 334 42 self)
					)
					(3
						(frontCloud2 posn: 182 43 setMotion: MoveTo 319 14 self)
					)
					(4
						(frontCloud2 posn: 182 43 setMotion: MoveTo 334 42 self)
					)
				)
			)
			(2 (self init:))
		)
	)
)

(instance sCloud of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 (Random 138 227))
				(cloud
					setCel: (Random 0 3)
					posn: local0 (Random 190 200)
					setStep: 10 (Random 10 15)
					setMotion: MoveTo local0 (Random 85 95) self
				)
			)
			(1 (self init:))
		)
	)
)

(instance sCloud2 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 (Random 249 340))
				(cloud2
					setCel: (Random 0 3)
					posn: local1 (Random 190 200)
					setStep: 10 (Random 10 15)
					setMotion: MoveTo local1 (Random 85 95) self
				)
			)
			(1 (self init:))
		)
	)
)

(instance theMusic3 of Sound
	(properties)
)

(instance console of Feature
	(properties
		x 162
		y 55
		nsTop 35
		nsLeft 70
		nsBottom 75
		nsRight 255
		description {konzola}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(global2 doVerb: theVerb param2 &rest)
	)
)

(instance throttle of Feature
	(properties
		x 158
		y 86
		nsTop 76
		nsLeft 131
		nsBottom 96
		nsRight 186
		description {plyn}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(global2 doVerb: theVerb param2 &rest)
	)
)

(instance windows of Feature
	(properties
		x 157
		y 34
		nsLeft 3
		nsBottom 69
		nsRight 312
		description {okno}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(global2 doVerb: theVerb param2 &rest)
	)
)

(instance sPlaneCartoon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 2))
			(1
				(proc0_3)
				(User canControl: 0)
				(gIconBar disable: 0)
				(= seconds 4)
			)
			(2
				(proc0_2)
				(proc0_14 390 14 108 self)
			)
			(3 (proc0_16) (= ticks 30))
			(4
				(proc0_2)
				(proc0_14 390 15 108 self)
			)
			(5 (proc0_16) (= seconds 30))
			(6
				(proc0_2)
				(proc0_14 390 16 108 self)
			)
			(7 (= ticks 30))
			(8 (proc0_14 390 17 108 self))
			(9 (= ticks 60))
			(10
				(= local3 1)
				(self setScript: sAutoPilot)
			)
		)
	)
)

(instance sAutoPilot of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local3
					(self cue:)
				else
					(proc0_2)
					(proc0_14 390 18 108 self)
				)
			)
			(1 (= ticks 60))
			(2
				(if (not local3) (proc0_10 100))
				(plane setLoop: 1 setCel: 0 setScript: 0)
				(wheel setCycle: Beg)
				(wheel2 setCycle: Beg)
				(sCloud dispose:)
				(sCloud2 dispose:)
				(sFrontCloud dispose:)
				(sFrontCloud2 dispose:)
				(= cycles 8)
			)
			(3
				(frontCloud show: setCel: 1 posn: 56 39)
				(frontCloud2 show: setCel: 2 posn: 249 44)
				(= local4 1)
				(proc0_14 390 19 108 self)
			)
			(4
				(cloud
					show:
					setCel: 0
					posn: 245 138
					xStep: 2
					moveSpeed: 10
					setMotion: MoveTo 120 138
				)
				(cloud2
					show:
					setCel: 3
					posn: 310 173
					xStep: 2
					moveSpeed: 10
					setMotion: MoveTo 180 173
				)
				(plane setLoop: 4 setCel: 0 setCycle: End self)
			)
			(5 (= seconds 4))
			(6
				(proc0_14 390 20 33 global175 70 200 30 1 108 self)
			)
			(7 (= ticks 120))
			(8 (proc0_14 390 21 108 self))
			(9 (global2 newRoom: 310))
		)
	)
)

(instance plane of Actor
	(properties
		x 249
		y 137
		description {tvoje letadlo}
		view 392
		loop 1
		priority 3
		signal $4810
	)
	
	(method (doVerb theVerb param2)
		(thePlane doVerb: theVerb &rest)
	)
)

(instance larry of Prop
	(properties
		x 70
		y 189
		description {sebe}
		view 391
		priority 6
		signal $4810
	)
	
	(method (doVerb theVerb param2)
		(bigLarry doVerb: theVerb &rest)
	)
	
	(method (cue)
		(if local4
			(self setCel: 2)
		else
			(self setCel: (Random 0 3))
			(proc0_17 (Random 2 4) 1 larry)
		)
	)
)

(instance bigLarry of Feature
	(properties
		x 79
		y 149
		z 7
		nsTop 96
		nsBottom 189
		nsRight 158
		description {ty}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 390 22))
			(5 (proc0_14 390 23))
			(3 (proc0_14 390 24))
			(4 (proc0_14 390 25))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance thePlane of Feature
	(properties
		x 238
		y 151
		z 9
		nsTop 95
		nsLeft 157
		nsBottom 189
		nsRight 319
		description {letadlo}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 390 26))
			(5 (proc0_14 390 27))
			(4 (proc0_14 390 28))
			(3 (proc0_14 390 29))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)
