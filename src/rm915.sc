;;; Sierra Script 1.0 - (do not remove this comment)
(script# 915)
(include sci.sh)
(use Main)
(use LLRoom)
(use RTRandCycle)
(use CueObj)
(use Cycle)
(use User)
(use PicView)
(use Obj)

(public
	rm915 0
)

(local
	local0
	local1
	local2
	local3
	local4
)
(instance rm915 of LLRoom
	(properties
		picture 915
	)
	
	(method (init)
		(Load rsVIEW 1915)
		(Load rsVIEW 915)
		(Load rsVIEW 916)
		(super init:)
		(chichis init:)
		(herEye init:)
		(herMouth init: hide:)
		(herButton init:)
		(boobs init: hide:)
		(proc0_3)
		(proc0_22 1)
		(User canControl: 0)
		(= local2 30)
		(if (!= gGNumber 910)
			(gLongSong number: 910 loop: -1 play:)
			(gLarry get: 21)
		)
	)
	
	(method (doit)
		(super doit:)
		(if (!= local1 (GetTime 1))
			(= local1 (GetTime 1))
			(if (not (-- local2))
				(proc0_2)
				(global2 setScript: sBackToWork)
			)
		)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(switch (Random 1 2)
					(1 (proc0_14 915 0))
					(2 (proc0_14 915 1))
				)
			)
			(4
				(switch param2
					(21
						(proc0_2)
						(proc0_10 15)
						(global2 setScript: sGiveGreen)
					)
					(else  (proc0_14 915 2))
				)
			)
			(5
				(proc0_2)
				(global2 setScript: sTalk)
			)
			(10
				(switch (Random 1 2)
					(1
						(proc0_18 Chi_Chi_Lambada 915 3 108)
					)
					(2
						(proc0_18 Chi_Chi_Lambada 915 4 108)
					)
				)
			)
			(3 (proc0_14 915 0))
			(1
				(proc0_2)
				(proc0_18 gLarry 915 5)
				(gLongSong fade:)
				(proc0_7 4)
				(global2 newRoom: 905)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance sTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= local2 1000)
				(= cycles 2)
			)
			(1
				(switch (++ local3)
					(1
						(proc0_18 gLarry 915 6 108 self)
					)
					(2
						(proc0_18 gLarry 915 7 108 self)
					)
					(3
						(proc0_18 Chi_Chi_Lambada 915 8 108 139 self)
					)
					(4
						(proc0_14 915 9 67 -1 185 108 self)
					)
					(5
						(proc0_18 Chi_Chi_Lambada 915 10 108 139 self)
					)
				)
			)
			(2 (= ticks 30))
			(3
				(switch local3
					(1
						(proc0_18 Chi_Chi_Lambada 915 11 108)
						(= ticks 123)
					)
					(2
						(proc0_18 Chi_Chi_Lambada 915 12 108)
						(= ticks 123)
					)
					(3
						(proc0_18 gLarry 915 13 108 self)
					)
					(4
						(proc0_18 Chi_Chi_Lambada 915 14 108)
						(= ticks 123)
					)
					(5
						(proc0_18 gLarry 915 15 108 self)
					)
				)
			)
			(4
				(switch local3
					(1
						(proc0_14 915 16 67 -1 185 108 self)
					)
					(2
						(proc0_3)
						(User canControl: 0)
						(= local2 30)
					)
					(3
						(proc0_18 Chi_Chi_Lambada 915 17 108)
						(= ticks 123)
					)
					(4
						(proc0_18 gLarry 915 18 108 self)
					)
					(5
						(proc0_7 51)
						(proc0_10 5)
						(global2 newRoom: 910)
					)
				)
			)
			(5
				(switch local3
					(1
						(proc0_3)
						(User canControl: 0)
						(= local2 30)
					)
					(3
						(proc0_18 gLarry 915 19 108 self)
					)
					(4
						(proc0_3)
						(User canControl: 0)
						(= local2 30)
					)
				)
			)
			(6
				(proc0_18 Chi_Chi_Lambada 915 20 108 139 self)
			)
			(7 (= ticks 60))
			(8
				(proc0_18 Chi_Chi_Lambada 915 21 108 139 self)
			)
			(9 (= ticks 60))
			(10
				(proc0_18 gLarry 915 22 108 self)
			)
			(11
				(proc0_3)
				(User canControl: 0)
				(= local2 30)
			)
		)
	)
)

(instance chichis of Feature
	(properties
		x 163
		y 255
		z 100
		nsTop 137
		nsLeft 113
		nsBottom 173
		nsRight 213
		description {her chi chis}
		sightAngle 40
	)
	
	(method (doVerb)
		(global2 doVerb: &rest)
	)
)

(instance herButton of Feature
	(properties
		x 158
		y 338
		z 200
		nsTop 131
		nsLeft 149
		nsBottom 146
		nsRight 167
		description {her button}
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(cond 
			((== theVerb 3)
				(if (not local0)
					(if (< (++ local4) 6)
						(proc0_2)
						(global2 setScript: sStopThat)
					else
						(proc0_2)
						(gIconBar disable:)
						(proc0_14 915 23)
						(proc0_10 2 166)
						(boobs show:)
						(= local0 1)
						(proc0_17 3 2 boobs)
					)
				)
			)
			((== theVerb 2) (proc0_14 915 24))
			(else (global2 doVerb: theVerb &rest))
		)
	)
)

(instance boobs of Prop
	(properties
		x 160
		y 172
		description {her chi chis}
		sightAngle 90
		view 916
		priority 14
		signal $4810
	)
	
	(method (doVerb)
		(global2 doVerb: &rest)
	)
	
	(method (cue)
		(global2 setScript: sHideBoobs)
	)
)

(instance Chi_Chi_Lambada of Talker
	(properties
		x 50
		y 140
		nsTop 68
		nsLeft 151
		view 1915
		loop 3
		talkWidth 220
		name "Chi Chi Lambada"
	)
	
	(method (init)
		(= mouth talkerMouth)
		(super init:)
	)
)

(instance talkerMouth of Prop
	(properties
		view 1915
	)
)

(instance herEye of Prop
	(properties
		x 170
		y 55
		description {her eyes}
		sightAngle 90
		view 915
		priority 14
		signal $4810
	)
	
	(method (doVerb theVerb param2)
		(global2 doVerb: theVerb &rest)
	)
)

(instance herMouth of Prop
	(properties
		x 157
		y 169
		z 100
		description {her mouth}
		sightAngle 90
		view 915
		loop 2
		priority 14
		signal $4810
	)
)

(instance sBackToWork of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= local2 1000)
				(= cycles 2)
			)
			(1
				(proc0_18 Chi_Chi_Lambada 915 25 108 139 self)
			)
			(2 (= ticks 30))
			(3 (herEye setCycle: End self))
			(4 (= ticks 60))
			(5 (herEye setCycle: Beg self))
			(6 (= ticks 30))
			(7 (global2 newRoom: 910))
		)
	)
)

(instance sHideBoobs of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= local2 1000)
				(= local4 0)
				(= local0 0)
				(= cycles 2)
			)
			(1
				(proc0_18 Chi_Chi_Lambada 915 26 108 139 self)
			)
			(2
				(boobs hide:)
				(gIconBar enable:)
				(= ticks 90)
			)
			(3 (= seconds 2))
			(4 (herEye setCycle: End self))
			(5 (= ticks 60))
			(6 (herEye setCycle: Beg self))
			(7 (= ticks 30))
			(8
				(proc0_3)
				(= local2 20)
				(self dispose:)
			)
		)
	)
)

(instance sStopThat of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= local2 1000)
				(= cycles 2)
			)
			(1
				(proc0_18 Chi_Chi_Lambada 915 27 108 139 self)
			)
			(2 (= ticks 20))
			(3
				(herMouth show: setLoop: 2 setCel: 0 setCycle: End self)
			)
			(4 (= ticks 60))
			(5
				(herMouth setCycle: Beg self)
			)
			(6
				(herMouth hide:)
				(= local2 20)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance sGiveGreen of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= local2 1000)
				(= cycles 2)
			)
			(1
				(proc0_18 gLarry 915 28 108 self)
			)
			(2 (= ticks 60))
			(3
				(proc0_18 Chi_Chi_Lambada 915 29 108 139 self)
			)
			(4
				(herMouth dispose:)
				(herEye dispose:)
				(= ticks 60)
			)
			(5
				(gLarry put: 21)
				(proc0_7 51)
				(global2 newRoom: 910)
			)
		)
	)
)
